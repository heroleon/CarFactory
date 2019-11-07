package com.leon.carfixfactory.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.leon.carfixfactory.R;
import com.leon.carfixfactory.bean.AccessoriesInfo;
import com.leon.carfixfactory.bean.CarPartsInfo;
import com.leon.carfixfactory.bean.DriverInfo;
import com.leon.carfixfactory.contract.OrderConfirmContact;
import com.leon.carfixfactory.presenter.OderConfirmPresenter;
import com.leon.carfixfactory.ui.adapter.ItemPartAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class RepairDetailActivity extends BaseActivity<OderConfirmPresenter> implements OrderConfirmContact.ViewOrderConfirm  {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_car_card)
    TextView tvCarCard;
    @Bind(R.id.tv_driver_name)
    TextView tvDriverName;
    @Bind(R.id.tv_driver_phone)
    TextView tvDriverPhone;
    @Bind(R.id.tv_accept_car_time)
    TextView tvAcceptTime;
    @Bind(R.id.tv_repair_content)
    TextView tvRepairDetail;

    @Bind(R.id.tv_car_duty_person)
    TextView tvDutyPerson;
    @Bind(R.id.tv_repair_time)
    TextView tvRepairTime;
    @Bind(R.id.tv_time_fee)
    TextView tvTimeFee;
    @Bind(R.id.rl_part_view)
    RecyclerView rlPartView;
    @Bind(R.id.tv_total_fee)
    TextView tvTotalFee;
    private ItemPartAdapter mAdapter;

    public final static String CAR_INFO = "car_info";
    private DriverInfo driverInfo;

    @Override
    protected void initPresenter(Intent intent) {
        mPresenter = new OderConfirmPresenter(this, this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_repair_detail;
    }

    @Override
    protected void initView() {
        tvTitle.setText(getString(R.string.title_repair_detail));
        driverInfo = (DriverInfo) getIntent().getSerializableExtra(CAR_INFO);
        initRecyclerView();
        initData();
    }
    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlPartView.setLayoutManager(linearLayoutManager);
        mAdapter = new ItemPartAdapter(this, R.layout.item_confirm_part);
        rlPartView.setAdapter(mAdapter);
        rlPartView.setNestedScrollingEnabled(false);
    }
    public void initData() {
      /*  mPresenter.getPartsList(driverInfo.carId);
        setText(tvCarCard, R.string.car_card_content, driverInfo.carCard);
        setText(tvDriverName, R.string.car_driver_name_content, driverInfo.driverName);
        setText(tvDriverPhone, R.string.car_driver_phone_content, driverInfo.driverPhone);
        driverInfo.acceptTime = DateTimeUtils.millisecondToDate(System.currentTimeMillis(), DateTimeUtils.YYYY_MM_DD_HH_MM);
        setText(tvAcceptTime, R.string.car_accept_time, driverInfo.acceptTime);
        tvRepairDetail.setText(driverInfo.maintenanceDetail);

        setText(tvDutyPerson, R.string.car_duty_person_content, driverInfo.dutyPerson);
        setText(tvRepairTime, R.string.car_repair_time_content, Utils.getFinalCashValue(driverInfo.workTime));
        setText(tvTimeFee, R.string.car_repair_fee_content, Utils.getFinalCashValue(driverInfo.workPrice));*/

    }

    private void setText(TextView tvView, int resId, String content) {
        tvView.setText(String.format(getString(resId), content));
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
    public void getCarPartsList(List<CarPartsInfo> responses) {
        double totalPartPrice = 0;
        /*if (responses != null && responses.size() > 0) {
            mAdapter.updateWithClear(responses);
            for (CarPartsInfo carpart : responses
            ) {
                totalPartPrice += carpart.partCount * Double.valueOf(carpart.partPrice);
            }
        } else {
            rlPartView.setVisibility(View.GONE);
        }*/
       // double totalPrice = driverInfo.workTime * driverInfo.workPrice + totalPartPrice;
       // setText(tvTotalFee, R.string.part_price, Utils.getFinalCashValue(totalPrice));
    }

    @Override
    public void getAccessoriesList(List<AccessoriesInfo> responses) {

    }

    @Override
    public void ShowToast(String t) {

    }
}
