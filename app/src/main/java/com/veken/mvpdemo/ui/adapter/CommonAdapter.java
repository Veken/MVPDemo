package com.veken.mvpdemo.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.veken.mvpdemo.R;
import com.veken.mvpdemo.bean.HotMovieBean;

import java.util.List;


/**
 * @author Veken
 * @date on 2018/2/2 10:30
 * @describe
 */

public class CommonAdapter extends BaseQuickAdapter<HotMovieBean.SubjectsBean, BaseViewHolder> {

    public CommonAdapter(@Nullable List<HotMovieBean.SubjectsBean> data) {
        super(R.layout.item_test, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, HotMovieBean.SubjectsBean item) {
        Glide.with(mContext).load(item.getImages().getLarge()).
                placeholder(R.mipmap.beautiful_girl).into((ImageView) holder.getView(R.id.iv_icon));
        holder.setText(R.id.tv_title,item.getTitle());
        holder.setText(R.id.tv_detail,item.getYear());
    }
}
