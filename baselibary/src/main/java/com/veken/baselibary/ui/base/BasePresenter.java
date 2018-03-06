package com.veken.baselibary.ui.base;



/**
 * @author Veken
 * @date on 2018/2/2 10:30
 * @describe
 */

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

    //1.View层的引用
    protected T mView;

    //进行绑定
    public void attachView(T view) {
        this.mView = view;
    }

    //解绑
    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }
}
