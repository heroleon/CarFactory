package com.leon.carfixfactory.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.leon.carfixfactory.MyApplication;
import com.leon.carfixfactory.R;
import com.leon.carfixfactory.bean.RepairRecord;
import com.leon.carfixfactory.beanDao.RepairRecordDao;
import com.leon.carfixfactory.contract.RepairRecordContact;
import com.leon.carfixfactory.presenter.RepairListImp;
import com.leon.carfixfactory.ui.adapter.RepairListAdapter;

import java.util.List;

import butterknife.Bind;

/**
 * Created by leon
 * Date: 2019/11/7
 * Time: 19:55
 * Desc:维修记录基类
 */
public class BaseRepairFragment extends BaseFragment<RepairListImp> implements RepairRecordContact.ViewRepairListView {

    @Bind(R.id.rv_record_view)
    RecyclerView rvRecordView;
    private RepairListAdapter mAdapter;
    protected boolean isDelivery;
    private RepairRecordDao repairRecordDao;

    @Override
    protected void initPresenter() {
        mPresenter = new RepairListImp(mActivity, this);
    }

    @Override
    protected void lazyLoad() {
        mPresenter.getRepairList(isDelivery);
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        repairRecordDao = MyApplication.getApplication().getDaoSession().getRepairRecordDao();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvRecordView.setLayoutManager(linearLayoutManager);
        mAdapter = new RepairListAdapter(getContext(), R.layout.item_repair_list);
        rvRecordView.setAdapter(mAdapter);
        mAdapter.setOnItemOptionClickListener(new RepairListAdapter.OnItemOptionClickListener() {
            @Override
            public void firstBtnClick(int position) {
                changeRepairState(position, 2);
            }

            @Override
            public void secondBtnClick(int position) {

            }

            @Override
            public void thirdBtnClick(int position) {
                changeRepairState(position, 1);
            }
        });
    }

    private void changeRepairState(int position, int type) {
        RepairRecord repairRecord = mAdapter.getItems(position);
        if (type == 2) {
            repairRecord.deliveryTime = System.currentTimeMillis();
        }
        repairRecord.repairState = type;
        repairRecordDao.update(repairRecord);
        if (type == 1) {
            mAdapter.notifyItemChanged(position);
        } else {
            mAdapter.delete(position);
        }

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_repair_record;
    }


    @Override
    public void getRepairRecordSuccess(List<RepairRecord> responses) {
        if (responses != null && responses.size() > 0) {
            mAdapter.updateWithClear(responses);
        }
    }

    @Override
    public void ShowToast(String t) {

    }
}
