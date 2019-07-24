package com.leon.carfixfactory.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.leon.carfixfactory.R;

import butterknife.Bind;
import butterknife.OnClick;

public class AddWorkerActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Override
    protected void initPresenter(Intent intent) {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_add_worker;
    }

    @Override
    protected void initView() {
        tvTitle.setText(getString(R.string.title_add_worker));
    }

    @OnClick(value = {R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
