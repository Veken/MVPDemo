package com.veken.baselibary.net;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Veken
 * @date on 2018/2/2 10:30
 * @describe  通用的RxJava线程转换类
 */
public class RxSchedulers {

    static final ObservableTransformer schedulersTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return (upstream).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };


    public static  ObservableTransformer applySchedulers() {
        return (ObservableTransformer) schedulersTransformer;
    }
}
