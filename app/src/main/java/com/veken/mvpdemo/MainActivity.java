package com.veken.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.veken.baselibary.utils.RouterCommonUtil;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moduleA(View view) {
        ARouter.getInstance().build(RouterCommonUtil.MOVIE_ACTIVITY).navigation();
    }

    public void moduleB(View view) {
        ARouter.getInstance().build(RouterCommonUtil.MODUlE_B_ACTIVITY)
                .withInt("num",100).navigation();
    }
}
