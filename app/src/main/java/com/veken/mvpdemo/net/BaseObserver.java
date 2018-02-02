package com.veken.mvpdemo.net;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author Veken
 * @date on 2018/2/2 10:30
 * @describe
 */
public abstract class BaseObserver<T> implements Observer<T> {

    public abstract void onSucess(T t);

    public abstract void onFail(Throwable e);

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull T t) {
        onSucess(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        onFail(e);
    }

    @Override
    public void onComplete() {

    }
}
