package com.mobile.lapdv.demobroadcast.screen.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by lap on 27/04/2018.
 */

public class PowerBroadCastReceiver extends BroadcastReceiver {

    private MainPresenter mMainPresenter;

    public PowerBroadCastReceiver(MainPresenter mMainPresenter) {
        this.mMainPresenter = mMainPresenter;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            mMainPresenter.handleMessage("Ket noi voi sac");
        } else if (intent.getAction().endsWith(Intent.ACTION_POWER_DISCONNECTED)) {
            mMainPresenter.handleMessage("Rut sac");
        }
    }
}
