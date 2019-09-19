package com.leon.carfixfactory.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leon.carfixfactory.R;
import com.leon.carfixfactory.bean.HomeData;
import com.leon.carfixfactory.contract.HomeContact;
import com.leon.carfixfactory.presenter.HomeDataPresenterImp;

import java.util.List;

public class ConfirmOrderFragment extends BaseFragment<HomeDataPresenterImp> implements  HomeContact.ViewHome  {

    @Override
    protected void initPresenter() {
        mPresenter = new HomeDataPresenterImp(getActivity(), this);
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_confirm_order;
    }

    @Override
    public void getHomeDataSuccess(List<HomeData> responses) {

    }

    @Override
    public void ShowToast(String t) {

    }
}
