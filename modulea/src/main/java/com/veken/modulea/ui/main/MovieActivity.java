package com.veken.modulea.ui.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.veken.baselibary.ui.base.BaseActivity;
import com.veken.baselibary.utils.RouterCommonUtil;
import com.veken.baselibary.utils.ToastUtil;
import com.veken.modulea.R;
import com.veken.modulea.bean.HotMovieBean;
import com.veken.modulea.ui.adapter.CommonAdapter;
import com.veken.modulea.ui.main.contract.HotMovieContract;
import com.veken.modulea.ui.main.presenter.HotMoviePresenter;

import java.util.List;

@Route(path = RouterCommonUtil.MOVIE_ACTIVITY)
public class MovieActivity extends BaseActivity<HotMoviePresenter> implements HotMovieContract.View {


    private RecyclerView recyclerView;

    @Override
    protected int layoutId() {
        return R.layout.activity_movie;
    }

    @Override
    protected void initData() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        presenter.getData();
    }

    /**
     * 初始化Presenter
     *
     * @return
     */
    @Override
    protected HotMoviePresenter createPresenter() {
        return new HotMoviePresenter();
    }


    @Override
    public void loadData(HotMovieBean hotMovieBeen) {
        List<HotMovieBean.SubjectsBean> subjects = hotMovieBeen.getSubjects();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CommonAdapter adapter = new CommonAdapter(subjects);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.toastShort(position + "");
            }
        });
    }

}
