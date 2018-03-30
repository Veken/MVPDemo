package com.veken.baselibary.ui.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.veken.baselibary.utils.UiUtils;

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
        //初始化Arouter
        initRouter(this);
    }

    public static BaseApplication getInstance(){
            return mContext;
    }


    private void initRouter(BaseApplication mApplication) {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (UiUtils.isApkInDebug(mContext)) {
            //打印日志
            ARouter.openLog();
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！
            //线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(mApplication);


    }
}
