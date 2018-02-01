package com.veken.mvpdemo.ui.main.modle;

import com.veken.mvpdemo.bean.HotMovieBean;


/**
 * @author Veken
 * @date on 2018/1/31 14:45
 * @describe 用来加载数据
 */

public interface TestModle {
    void loadData(OnLoadListener onLoadListener);
    //设计一个内部回调接口
    interface OnLoadListener{
        void Complete(HotMovieBean hotMovieBean);
    }
}
