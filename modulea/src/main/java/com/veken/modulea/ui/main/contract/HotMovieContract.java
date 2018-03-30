package com.veken.modulea.ui.main.contract;

import com.veken.baselibary.ui.base.BaseContract;
import com.veken.modulea.bean.HotMovieBean;


/**
 * @author Veken
 * @date on 2018/1/31 14:45
 * @describe 用来加载数据
 */

public interface HotMovieContract {
    interface View extends BaseContract.BaseView{
        void loadData(HotMovieBean hotMovieBeen);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getData();
    }
}
