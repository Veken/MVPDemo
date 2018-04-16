package com.veken.moduleb.ui;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.veken.baselibary.ui.base.BaseActivity;
import com.veken.baselibary.utils.RouterCommonUtil;
import com.veken.baselibary.utils.ToastUtil;
import com.veken.moduleb.R;

@Route(path = RouterCommonUtil.MODUlE_B_ACTIVITY)
public class ModuleBActivity extends BaseActivity implements ModuleBContract.View {

    //用注解接收传递过来的参数
    @Autowired
    int num;


    @Override
    protected int layoutId() {
        return R.layout.activity_module_b;
    }


    @Override
    protected void initData() {
        //接收参数初始化
        ARouter.getInstance().inject(this);
        showDialog = false;
        ToastUtil.toastShort(num+"");
    }

    @Override
    protected ModuleBPresenter createPresenter() {
        return null;
    }


    @Override
    public void loadData() {
    }

    public void toModuleA(View view) {
        ARouter.getInstance().build(RouterCommonUtil.MOVIE_ACTIVITY).navigation();
    }
}
