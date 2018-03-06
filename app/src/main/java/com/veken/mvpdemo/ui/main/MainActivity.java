package com.veken.mvpdemo.ui.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.veken.baselibary.ui.base.BaseActivity;
import com.veken.baselibary.utils.ToastUtil;
import com.veken.mvpdemo.R;
import com.veken.mvpdemo.bean.HotMovieBean;
import com.veken.mvpdemo.ui.adapter.CommonAdapter;
import com.veken.mvpdemo.ui.main.contract.HotMovieContract;
import com.veken.mvpdemo.ui.main.presenter.HotMoviePresenter;

import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity<HotMoviePresenter> implements HotMovieContract.View {


    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    /**
     * 初始化Presenter
     * @return
     */
    @Override
    protected HotMoviePresenter createPresenter() {
        return new HotMoviePresenter();
    }


    @Override
    public void loadData(HotMovieBean hotMovieBeen) {
        List<HotMovieBean.SubjectsBean> subjects = hotMovieBeen.getSubjects();
        CommonAdapter adapter = new CommonAdapter(subjects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.toastShort(position + "");
            }
        });
    }
}
