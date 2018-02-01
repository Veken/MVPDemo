package com.veken.mvpdemo.ui.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.veken.mvpdemo.R;
import com.veken.mvpdemo.bean.HotMovieBean;
import com.veken.mvpdemo.ui.adapter.CommonAdapter;
import com.veken.mvpdemo.ui.base.BaseActivity;
import com.veken.mvpdemo.ui.main.presenter.TestPresenter;
import com.veken.mvpdemo.utils.ToastUtil;

import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity<TestView,TestPresenter<TestView>> implements TestView {


    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        presenter.fetch();
    }

    @Override
    protected TestPresenter<TestView> createPresenter() {
        return new TestPresenter<>();
    }

    @Override
    public void showLoading() {
        showLoadingDialog();
    }

    @Override
    public void showData(HotMovieBean hotMovieBean) {
        dialog.dismiss();
        List<HotMovieBean.SubjectsBean> subjects = hotMovieBean.getSubjects();
        CommonAdapter adapter = new CommonAdapter(subjects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.toastShort(MainActivity.this,position + "");
            }
        });
    }

}
