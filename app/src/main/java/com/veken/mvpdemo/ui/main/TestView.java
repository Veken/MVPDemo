package com.veken.mvpdemo.ui.main;

import com.veken.mvpdemo.bean.HotMovieBean;


/**
 * @author Veken
 * @date on 2018/1/31 14:44
 * @describe   用来显示View
 */

public interface TestView {
    void showLoading();

    void showData(HotMovieBean hotMovieBean);
}
