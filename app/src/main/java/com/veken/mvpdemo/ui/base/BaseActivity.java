package com.veken.mvpdemo.ui.base;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.veken.mvpdemo.utils.DialogLoading;

import butterknife.ButterKnife;

public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {

    //表示层的引用
    protected T presenter;

    protected Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        ButterKnife.bind(this);
        presenter = createPresenter();
        presenter.attachView((V)this);
        //加载数据
        initData();
        dialog = DialogLoading.getLoadingDialog(this);
    }

    protected abstract int layoutId();

    protected abstract void initData();

    protected void showLoadingDialog(){
        if(dialog!=null){
            dialog.show();
        }
    }

    protected abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView((V)this);
        ButterKnife.unbind(this);
    }
}
