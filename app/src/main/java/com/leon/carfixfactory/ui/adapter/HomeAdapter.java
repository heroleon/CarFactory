package com.leon.carfixfactory.ui.adapter;

import android.content.Context;


import com.leon.carfixfactory.R;
import com.leon.carfixfactory.bean.HomeData;
import com.leon.carfixfactory.ui.adapter.base.BaseRecyclerAdapter;
import com.leon.carfixfactory.ui.adapter.base.BaseRecyclerHolder;

public class HomeAdapter extends BaseRecyclerAdapter<HomeData> {

    public HomeAdapter(Context context, int itemLayoutId) {
        super(context, itemLayoutId);
    }

    @Override
    public void convert(BaseRecyclerHolder holder, HomeData item, int position) {
        holder.setImageResource(R.id.iv_icon, getIconRes(item.icon));
        holder.setText(R.id.tv_title, item.title);
    }

    private int getIconRes(String idRes) {
        return context.getResources().getIdentifier(idRes, "mipmap", context.getPackageName());
    }
}
