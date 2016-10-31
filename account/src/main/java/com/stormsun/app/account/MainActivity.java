package com.stormsun.app.account;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    private String			_tag	= MainActivity.class.getSimpleName();
    private TextView _accountList;
    private AccountManager _am;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_accounts);

        _accountList = (TextView) findViewById(R.id.manage_accounts_accountlist);
		/* 取得AccountManager对象 */
        _am = AccountManager.get(this);

        Button newacc = (Button) findViewById(R.id.manage_accounts_newaccount);
        newacc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                _am.addAccount(getString(R.string.ACCOUNT_TYPE), null, null, null, MainActivity.this,
                        new AccountManagerCallback<Bundle>() {
                    @Override
                    public void run(AccountManagerFuture<Bundle> amfuture)
                    {
                        try
                        {
                            Log.d(_tag, amfuture.getResult().toString());
                        }
                        catch (Exception e)
                        {
                            Log.e(_tag, e.getMessage(), e);
                        }
                        listAccounts();
                    }
                }, null);
            }
        });
        listAccounts();
    }

    /* 显示出所有账户 */
    @NeedsPermission(Manifest.permission.GET_ACCOUNTS)
    public void listAccounts()
    {
		/* 得到指定类型的账户 */
        Account[] accounts = _am.getAccountsByType(getString(R.string.ACCOUNT_TYPE));
        _accountList.setText("账户列表：");
        StringBuilder sb = new StringBuilder();
        for (Account account : accounts)
        {
            String password = _am.getPassword(account);
            String sfz = _am.getUserData(account, "sfz");
            sb.append( '\n' + account.name + "  \n" + password + "  \n" + sfz + "\n*************************");
        }
        _accountList.setText(sb.toString());
    }

    @OnShowRationale(Manifest.permission.GET_ACCOUNTS)
    void showRationaleForCamera(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage("访问时")
                .setPositiveButton("好", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton("不好", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .show();
    }

    @OnPermissionDenied(Manifest.permission.GET_ACCOUNTS)
    void showDeniedForCamera() {
        Toast.makeText(this, "权限拒绝", Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain(Manifest.permission.GET_ACCOUNTS)
    void showNeverAskForCamera() {
        Toast.makeText(this, "不再询问（拒绝）", Toast.LENGTH_SHORT).show();
    }
}
