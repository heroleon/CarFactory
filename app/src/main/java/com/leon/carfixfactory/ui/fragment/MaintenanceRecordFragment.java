package com.leon.carfixfactory.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.leon.carfixfactory.R;
import com.leon.carfixfactory.bean.HomeData;
import com.leon.carfixfactory.bean.ItemEditContent;
import com.leon.carfixfactory.contract.HomeContact;
import com.leon.carfixfactory.contract.ItemEditTextContact;
import com.leon.carfixfactory.presenter.EditContentImp;
import com.leon.carfixfactory.presenter.HomeDataPresenterImp;
import com.leon.carfixfactory.utils.ContentViewSetting;

import java.util.List;

import butterknife.Bind;

public class MaintenanceRecordFragment extends BaseFragment<EditContentImp> implements ItemEditTextContact.ViewEditContent {


    @Override
    protected void initPresenter() {
        mPresenter = new EditContentImp(getActivity(), this);
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_maintenance_content;
    }


    @Override
    public void ShowToast(String t) {
        showToast(t);
    }

    @Override
    public void getItemDataSuccess(List<ItemEditContent> responses) {

    }
}
