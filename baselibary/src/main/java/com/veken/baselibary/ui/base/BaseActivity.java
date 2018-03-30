package com.veken.baselibary.ui.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.veken.baselibary.utils.DialogLoading;
import com.veken.baselibary.utils.NetworkUtil;
import com.veken.baselibary.utils.ToastUtil;



public abstract class BaseActivity<T extends BaseContract.BasePresenter> extends AppCompatActivity implements BaseContract.BaseView {

    //表示层的引用
    @Nullable
    protected T presenter;

    protected Dialog dialog;

//    private Unbinder unbinder;

    protected boolean showDialog = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
//        unbinder =  ButterKnife.bind(this);
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
        if(showDialog){
            dialog = DialogLoading.getLoadingDialog(this);
        }
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
        if (dialog != null&&showDialog) {
            dialog.show();
        }
    }


    /**
     * 绑定RxJava的生命周期,类似于以前的Disposable或者是CompositeDisposable切断联系，避免造成内存泄漏
     * CompositeDisposable是Disposable的容器，需要切断一个联系，就把Disposable添加到CompositeDisposable中，
     * 在退出的时候调用CompositeDisposable.clear()，清楚所有
     * @param
     * @return
     */

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
//        unbinder.unbind();
    }
}
