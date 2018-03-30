package com.veken.baselibary.ui.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * @author Veken
 * @date on 2018/2/2 10:30
 * @describe
 */

public interface BaseContract {

    interface BasePresenter<T extends BaseContract.BaseView> {

        void attachView(T view);

        void detachView();
    }

    interface BaseView{
        //显示进度中
        void showLoading();

        //显示请求成功
        void showSuccess();

        //失败重试
        void showFaild();

        //显示当前网络不可用
        void showNoNet();

        //重试
        void onRetry();
    }
}
