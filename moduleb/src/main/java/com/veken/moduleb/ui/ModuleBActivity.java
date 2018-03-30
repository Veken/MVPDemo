package com.veken.moduleb.ui;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.veken.baselibary.ui.base.BaseActivity;
import com.veken.baselibary.utils.RouterCommonUtil;
import com.veken.moduleb.R;

@Route(path = RouterCommonUtil.MODUlE_B_ACTIVITY)
public class ModuleBActivity extends BaseActivity implements ModuleBContract.View {


    @Override
    protected int layoutId() {
        return R.layout.activity_module_b;
    }

    @Override
    protected void initData() {
        showDialog = false;
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
