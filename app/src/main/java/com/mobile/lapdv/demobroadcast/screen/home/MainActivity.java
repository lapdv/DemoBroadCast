package com.mobile.lapdv.demobroadcast.screen.home;

import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobile.lapdv.demobroadcast.R;
import com.mobile.lapdv.demobroadcast.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener, MainView {

    private Button btnSendBroadCast;
    private TextView tvMessage;
    private MainPresenter mainPresenter;
    private PowerBroadCastReceiver powerBroadCastReceiver;

    @Override
    protected void initView() {
        btnSendBroadCast = findViewById(R.id.btn_send_broad_cast);
        btnSendBroadCast.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mainPresenter = new MainPresenter();
        mainPresenter.setOnView(this);
        mainPresenter.onStart();
        tvMessage = findViewById(R.id.tv_message);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send_broad_cast:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                powerBroadCastReceiver = new PowerBroadCastReceiver(mainPresenter);
                registerReceiver(powerBroadCastReceiver, intentFilter);
                break;
        }
    }

    @Override
    public void showMessage(String message) {
        tvMessage.setText(!TextUtils.isEmpty(message) ? message : "");
    }

    @Override
    protected void onStop() {
        unregisterReceiver(powerBroadCastReceiver);
        super.onStop();
    }
}
