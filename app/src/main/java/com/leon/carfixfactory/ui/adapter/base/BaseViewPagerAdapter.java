package com.leon.carfixfactory.ui.adapter.base;

import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.leon.carfixfactory.ui.fragment.BaseFragment;

import java.util.List;

public class BaseViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> fragments;
    private List<String> mTitleList;
    private String[] mTitles;

    public BaseViewPagerAdapter(FragmentManager fragmentManager, List<BaseFragment> fragments) {
        super(fragmentManager);
        this.fragments = fragments;
    }

    public BaseViewPagerAdapter(FragmentManager fragmentManager, List<BaseFragment> fragments, String[] mTitles) {
        super(fragmentManager);
        this.fragments = fragments;
        this.mTitles = mTitles;
    }

    public BaseViewPagerAdapter(FragmentManager fragmentManager, List<BaseFragment> fragments, List<String> mTitleList) {
        super(fragmentManager);
        this.fragments = fragments;
        this.mTitleList = mTitleList;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(mTitles!=null && mTitles.length>0){
            return mTitles[position];
        }else if(mTitleList!=null && mTitleList.size()>0){
            return mTitleList.get(position);
        }else {
            return "无标题";
        }
    }

    @Override
    public int getCount() {
        return fragments!=null?fragments.size():0;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    public void setPagerTitle(String[] mTitles){
        this.mTitles=mTitles;
        notifyDataSetChanged();
    }
}
