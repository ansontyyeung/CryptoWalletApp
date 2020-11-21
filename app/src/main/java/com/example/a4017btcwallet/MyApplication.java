package com.example.a4017btcwallet;

import android.app.Application;

import com.example.a4017btcwallet.utils.Xutils;

import org.xutils.BuildConfig;
import org.xutils.x;



public class MyApplication extends Application {

    private static MyApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        //Whether to output debug log
        x.Ext.setDebug(BuildConfig.DEBUG);

    }


    public static MyApplication getInstance() {
        return instance;
    }
}

