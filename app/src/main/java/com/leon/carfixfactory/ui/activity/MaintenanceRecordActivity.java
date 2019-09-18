package com.leon.carfixfactory.ui.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.leon.carfixfactory.R;
import com.leon.carfixfactory.bean.ItemEditContent;
import com.leon.carfixfactory.contract.AddWorkerContact;
import com.leon.carfixfactory.presenter.AddWorkerImp;
import com.leon.carfixfactory.ui.fragment.CarInfoFragment;
import com.leon.carfixfactory.ui.fragment.ConfirmOrderFragment;
import com.leon.carfixfactory.ui.fragment.MaintenanceRecordFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MaintenanceRecordActivity extends BaseActivity<AddWorkerImp> implements AddWorkerContact.ViewAddWorker {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.vp)
    ViewPager viewPager;
    private List<Fragment> fragmentList;
    private String[] titles;

    @Override
    protected void initPresenter(Intent intent) {
        mPresenter = new AddWorkerImp(this, this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_maintenance_record;
    }

    @Override
    protected void initView() {
        initFragmentList();
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tvTitle.setText(titles[i]);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initFragmentList() {
        titles = getResources().getStringArray(R.array.maintenance_title);
        tvTitle.setText(titles[0]);
        fragmentList = new ArrayList<>();
        fragmentList.add(new CarInfoFragment());
        fragmentList.add(new MaintenanceRecordFragment());
        fragmentList.add(new ConfirmOrderFragment());
    }

    @Override
    public void getItemDataSuccess(List<ItemEditContent> responses) {

    }

    @Override
    public void ShowToast(String t) {

    }
}
