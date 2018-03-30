package com.veken.moduleb.ui;

import com.veken.baselibary.ui.base.BaseContract;

/**
 * @author Veken
 * @date on 2018/3/30 11:36
 * @describe
 */

public class ModuleBContract {
    interface View extends BaseContract.BaseView{
        void loadData();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getData();
    }
}
