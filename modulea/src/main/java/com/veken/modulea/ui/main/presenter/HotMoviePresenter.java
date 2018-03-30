package com.veken.modulea.ui.main.presenter;


import com.veken.baselibary.net.BaseObserver;
import com.veken.baselibary.net.RetrofitHandle;
import com.veken.baselibary.net.RxSchedulers;
import com.veken.baselibary.ui.base.BasePresenter;
import com.veken.modulea.bean.HotMovieBean;
import com.veken.modulea.net.HotMovieService;
import com.veken.modulea.ui.main.contract.HotMovieContract;


/**
 * @author Veken
 * @date on 2018/1/31 14:49
 * @describe 表示层
 */

public class HotMoviePresenter extends BasePresenter<HotMovieContract.View> implements HotMovieContract.Presenter {
    HotMovieService hotMovieService;

    @Override
    public void getData() {
        if (hotMovieService == null) {
            hotMovieService = RetrofitHandle.getInstance().retrofit.create(HotMovieService.class);
        }
        hotMovieService.fetchMovieTop250(0, 30)
                .compose(RxSchedulers.applySchedulers())
                .subscribe(new BaseObserver<HotMovieBean>() {
                    @Override
                    public void onSucess(HotMovieBean hotMovieBean) {
                        mView.loadData(hotMovieBean);
                        //如果不想要加载成功后的显示，比如弹一个toast，可以取消
                        mView.showSuccess();
                    }

                    @Override
                    public void onFail(Throwable e) {
                        mView.showFaild();
                    }
                });
    }
}
