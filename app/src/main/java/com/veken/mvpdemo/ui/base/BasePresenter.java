package com.veken.mvpdemo.ui.base;


import java.lang.ref.WeakReference;

/**
 * @author Veken
 * @date on 2018/1/31 11:30
 * @describe
 */

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

    //1.View层的引用
    protected T mView;

    //进行绑定
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }
}
