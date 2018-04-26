package com.mobile.lapdv.demobroadcast.screen.home;

/**
 * Created by lap on 27/04/2018.
 */

public class MainPresenter implements IMainPresenter {

    private MainView mainView;

    @Override
    public void setOnView(MainView view) {
        this.mainView = view;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void handleMessage(String message) {
        if (mainView != null && message != null) {
            mainView.showMessage(message);
        }
    }
}
