package com.veken.baselibary.ui.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.veken.baselibary.utils.DialogLoading;
import com.veken.baselibary.utils.NetworkUtil;
import com.veken.baselibary.utils.ToastUtil;

import butterknife.ButterKnife;


public abstract class BaseActivity<T extends BaseContract.BasePresenter> extends RxAppCompatActivity implements BaseContract.BaseView {

    //表示层的引用
    @Nullable
    protected T presenter;

    protected Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        ButterKnife.bind(this);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        //没有网络
        if(!NetworkUtil.isNetworkConnected(this)){
            showNoNet();
            return;
        }
        //加载数据
        initData();
        dialog = DialogLoading.getLoadingDialog(this);
    }


    /**
     * 布局资源
     * @return
     */
    protected abstract int layoutId();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 创建当前presenter
     * @return
     */
    protected abstract T createPresenter();

    /**
     * 没有网络
     */
    @Override
    public void showNoNet() {
        dismissDialog();
        ToastUtil.toastLong("没有网络访问");
    }

    /**
     * 重新加载
     */
    @Override
    public void onRetry() {
        initData();
    }

    @Override
    public void showSuccess() {
        ToastUtil.toastLong("加载成功");
        dismissDialog();
    }

    /**
     * 加载进度消失
     */
    private void dismissDialog(){
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /**
     * 加载失败
     */
    @Override
    public void showFaild() {
        dismissDialog();
        ToastUtil.toastLong("加载失败");
    }

    @Override
    public void showLoading() {
        if (dialog != null) {
            dialog.show();
        }
    }


    /**
     * 绑定RxJava的生命周期,类似于以前的Disposable或者是CompositeDisposable切断联系，避免造成内存泄漏
     *
     * @param <T>
     * @return
     */
    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.bindToLifecycle();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
        ButterKnife.unbind(this);
    }
}
