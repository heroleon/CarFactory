package com.leon.carfixfactory.ui.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.leon.carfixfactory.R;
import com.leon.carfixfactory.utils.ZToast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseFragmentActivity {
    @Bind(R.id.btn_home)
    Button mHome;
    @Bind(R.id.iv_scan)
    ImageView ivScan;
    @Bind(R.id.btn_mine)
    Button mMine;
    private int mRequestCode = 1000;

    @Override
    protected void initView() {
        mHome.setBackgroundResource(R.drawable.homepage_press);
        fragments = new ArrayList<>();
        fragmentManager = getSupportFragmentManager();
        fragments.add(fragmentManager.findFragmentById(R.id.fm_home));
        fragments.add(fragmentManager.findFragmentById(R.id.fm_mine));
        selectTab(0);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == mRequestCode) {
            if (resultCode == 2) {
                if (data != null) {
                    ArrayList<String> hphms = data.getStringArrayListExtra("HPHMS");
                    if (hphms == null) {
                        ZToast.makeText(this, "车牌识别异常，请重试", 1000).show();
                        return;
                    }
                    if (hphms.size() > 1) {
                        ZToast.makeText(this, hphms.get(0), 1000).show();
                    }
                }

            }
        }
    }
}