package com.example.luckychuan.logisticsquery.retrofit;

import android.app.Application;

/**
 * Created by Luckychuan on 2017/4/17.
 */
public class RetrofitApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitUtil.getInstance().init(this);
    }
}
