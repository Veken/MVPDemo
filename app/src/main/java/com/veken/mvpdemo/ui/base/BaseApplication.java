package com.veken.mvpdemo.ui.base;

import android.app.Application;

/**
 * @author Veken
 * @date on 2018/2/2 14:18
 * @describe
 */

public class BaseApplication extends Application {

    private static BaseApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static BaseApplication getInstance(){
            return mContext;
    }

}
