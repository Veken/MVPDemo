package com.veken.mvpdemo.ui.main.presenter;

import com.veken.mvpdemo.bean.HotMovieBean;
import com.veken.mvpdemo.ui.base.BasePresenter;
import com.veken.mvpdemo.ui.main.TestView;
import com.veken.mvpdemo.ui.main.modle.TestModle;
import com.veken.mvpdemo.ui.main.modle.TestModleImpl;

import java.util.List;

/**
 * @author Veken
 * @date on 2018/1/31 14:49
 * @describe 表示层
 */

public class TestPresenter<T extends TestView> extends BasePresenter<T> {

    //2.Modle层的引用
    TestModle testModle = new TestModleImpl();

    public TestPresenter() {
    }


    //执行操作(UI逻辑)
    public void fetch() {
        if (mRefView.get() != null) {
            mRefView.get().showLoading();
            if (testModle != null) {
                testModle.loadData(new TestModle.OnLoadListener() {
                    @Override
                    public void Complete(HotMovieBean hotMovieBean) {
                        if (mRefView.get() != null) {
                            mRefView.get().showData(hotMovieBean);
                        }
                    }
                });
            }
        }
    }
}
