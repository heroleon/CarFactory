package com.leon.carfixfactory.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.leon.carfixfactory.R;
import com.leon.carfixfactory.bean.WorkerInfo;
import com.leon.carfixfactory.contract.WorkerManageContact;
import com.leon.carfixfactory.presenter.WorkerManageImp;
import com.leon.carfixfactory.ui.adapter.WorkerManageAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class WorkerManageActivity extends BaseActivity<WorkerManageImp> implements WorkerManageContact.ViewWorkerManage {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private WorkerManageAdapter mAdapter;

    @Override
    protected void initPresenter(Intent intent) {
        mPresenter = new WorkerManageImp(this, this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_worker_manage;
    }

    @Override
    protected void initView() {
        tvTitle.setText(getString(R.string.title_worker_manage));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new WorkerManageAdapter(this, R.layout.item_worker_manage);
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.getWorkerManageData();
    }

    @Override
    public void getWorkerManageDataSuccess(List<WorkerInfo> responses) {
        if (responses != null && responses.size() > 0) {
            mAdapter.updateWithClear(responses);
        }
    }

    @OnClick(value = {R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    public void ShowToast(String t) {

    }
}
