package com.veken.mvpdemo.ui.base;


import java.lang.ref.WeakReference;

/**
 * @author Veken
 * @date on 2018/1/31 11:30
 * @describe
 */

public class BasePresenter<T> {

    //1.View层的引用
    protected WeakReference<T> mRefView;

    //进行绑定
    public void attachView(T view) {
        mRefView = new WeakReference<T>(view);
    }

    //进行解绑
    public void detachView(T View) {
        mRefView.clear();
    }

}
