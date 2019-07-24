package com.leon.carfixfactory.ui.activity;


import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.leon.carfixfactory.R;
import com.leon.carfixfactory.ui.custom.MoreWindow;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseFragmentActivity {
    @Bind(R.id.btn_home)
    Button mHome;
    @Bind(R.id.iv_scan)
    ImageView ivScan;
    @Bind(R.id.ll_root)
    LinearLayout llRoot;
    @Bind(R.id.btn_mine)
    Button mMine;
    private MoreWindow mMoreWindow;

    @Override
    protected void initView() {
        mHome.setBackgroundResource(R.drawable.homepage_press);
        fragments = new ArrayList<>();
        fragmentManager = getSupportFragmentManager();
        fragments.add(fragmentManager.findFragmentById(R.id.fm_home));
        fragments.add(fragmentManager.findFragmentById(R.id.fm_mine));
        selectTab(0);

        mMoreWindow = new MoreWindow(this);
        mMoreWindow.init(llRoot);

    }

    @OnClick(R.id.btn_home)
    public void toHomeFragment(View view) {
        selectTab(0);
        resetBottomBtn();
        mHome.setBackgroundResource(R.drawable.homepage_press);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            initStatusBar(false);
        }
    }

    @OnClick(R.id.iv_scan)
    public void toBookShelfFragment(View view) {
        showMoreWindow();
    }
    private void showMoreWindow() {
        if (null == mMoreWindow) {
            mMoreWindow = new MoreWindow(this);
            mMoreWindow.init(llRoot);
        }
        mMoreWindow.showMoreWindow(llRoot );
    }
    @OnClick(R.id.btn_mine)
    public void toMineFragment(View view) {
        selectTab(1);
        resetBottomBtn();
        mMine.setBackgroundResource(R.drawable.mine_press);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            initStatusBar(false);
        }
    }

    public void resetBottomBtn() {
        mHome.setBackgroundResource(R.drawable.homepage);
        mMine.setBackgroundResource(R.drawable.mine);
    }
}