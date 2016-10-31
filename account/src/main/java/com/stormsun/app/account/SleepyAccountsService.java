package com.stormsun.app.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.stormsun.app.account.auth.SleepyAccountAuthenticator;


public class SleepyAccountsService extends Service
{
	private SleepyAccountAuthenticator _saa;
	@Override
	public IBinder onBind(Intent intent)
	{
		IBinder ret = null;
		if (intent.getAction().equals(android.accounts.AccountManager.ACTION_AUTHENTICATOR_INTENT))
			ret = getSleepyAuthenticator().getIBinder();
		return ret;
	}
	private SleepyAccountAuthenticator getSleepyAuthenticator()
	{
		if (_saa == null)
			_saa = new SleepyAccountAuthenticator(this);
		return _saa;
	}
}
