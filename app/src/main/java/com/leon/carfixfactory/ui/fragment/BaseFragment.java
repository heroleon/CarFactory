package com.leon.carfixfactory.ui.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leon.carfixfactory.presenter.BasePresenter;
import com.leon.carfixfactory.ui.activity.BaseFragmentActivity;
import com.leon.carfixfactory.utils.ZToast;

import butterknife.ButterKnife;

/**
 * Created by leon.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected P mPresenter;
    //初始化Presenter
    protected abstract void initPresenter();

    protected Activity mActivity;

    protected abstract void initView(View view, Bundle savedInstanceState);

    //获取布局文件ID
    protected abstract int getLayoutId();

    //获取宿主Activity
    protected Activity getHoldingActivity() {
        return mActivity;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initPresenter();
        checkPresenterIsNull();
        initView(view, savedInstanceState);
        return view;
    }

    private void checkPresenterIsNull() {
        if (mPresenter == null) {
            throw new IllegalStateException("please init mPresenter in initPresenter() method ");
        }
    }

    public void showToast(String text){
        ZToast.makeText(mActivity, text,1000).show();
    }
}
