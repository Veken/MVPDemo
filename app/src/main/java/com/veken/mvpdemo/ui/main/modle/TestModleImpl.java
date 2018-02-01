package com.veken.mvpdemo.ui.main.modle;

import com.veken.mvpdemo.bean.HotMovieBean;
import com.veken.mvpdemo.net.BaseObserver;
import com.veken.mvpdemo.net.RetrofitHandle;
import com.veken.mvpdemo.net.RxSchedulers;
import com.veken.mvpdemo.net.Service;

import java.util.List;


/**
 * @author Veken
 * @date on 2018/1/31 14:56
 * @describe   数据来源
 */

public class TestModleImpl implements TestModle {
    @Override
    public void loadData(final OnLoadListener onLoadListener) {
        Service service = RetrofitHandle.getInstance().retrofit.create(Service.class);
        service.fetchMovieTop250(0,30)
                .compose(RxSchedulers.<HotMovieBean>applySchedulers())
                .subscribe(new BaseObserver<HotMovieBean>() {
                    @Override
                    public void onSucess(HotMovieBean hotMovieBean) {
                        onLoadListener.Complete(hotMovieBean);
                    }

                    @Override
                    public void onFail(Throwable e) {

                    }
                });


    }
}
