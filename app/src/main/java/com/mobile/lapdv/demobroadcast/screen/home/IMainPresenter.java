package com.mobile.lapdv.demobroadcast.screen.home;

import com.mobile.lapdv.demobroadcast.base.BasePresenter;

/**
 * Created by lap on 27/04/2018.
 */

public interface IMainPresenter extends BasePresenter<MainView> {
    void handleMessage(String message);
}
