package com.stormsun.app.account.auth;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.stormsun.app.account.R;


public class SleepyAccountAuthenticatorActivity extends AccountAuthenticatorActivity
{

	@Override
	protected void onCreate(Bundle icicle)
	{
		super.onCreate(icicle);
		setContentView(R.layout.new_account);

		final Button done = (Button) findViewById(R.id.new_account_done);
		final EditText sfz = (EditText) findViewById(R.id.new_account_sfz);
		final EditText username = (EditText) findViewById(R.id.new_account_username);
		final EditText password = (EditText) findViewById(R.id.new_account_password);

		done.setOnClickListener(new OnClickListener() {
			public void onClick(View v)
			{
				//Account--指定账户名和账户类型
				Account account = new Account(username.getText().toString(), getString(R.string.ACCOUNT_TYPE));
				//服务器数据
				Bundle userdata = new Bundle();
				userdata.putString("sfz", sfz.getText().toString());
				//取得AccountManager
				AccountManager am = AccountManager.get(SleepyAccountAuthenticatorActivity.this);
				//添加一个账户
				if (am.addAccountExplicitly(account, password.getText().toString(), userdata))
				{
					Bundle result = new Bundle();
					result.putString(AccountManager.KEY_ACCOUNT_NAME, username.getText().toString());
					result.putString(AccountManager.KEY_ACCOUNT_TYPE, getString(R.string.ACCOUNT_TYPE));
					setAccountAuthenticatorResult(result);
				}
				finish();
			}
		});
	}

}
