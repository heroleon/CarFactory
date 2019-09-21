package com.leon.carfixfactory.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.leon.carfixfactory.R;
import com.leon.carfixfactory.bean.CarInfo;
import com.leon.carfixfactory.bean.CarPartsInfo;
import com.leon.carfixfactory.bean.HomeData;
import com.leon.carfixfactory.contract.HomeContact;
import com.leon.carfixfactory.contract.OrderConfirmContact;
import com.leon.carfixfactory.presenter.HomeDataPresenterImp;
import com.leon.carfixfactory.presenter.OderConfirmPresenter;
import com.leon.carfixfactory.ui.adapter.ItemPartAdapter;
import com.leon.carfixfactory.utils.DateTimeUtils;
import com.leon.carfixfactory.utils.Utils;


import java.util.List;

import butterknife.Bind;

public class ConfirmOrderFragment extends BaseFragment<OderConfirmPresenter> implements OrderConfirmContact.ViewOrderConfirm {
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
    private CarInfo carInfo;

    @Override
    protected void initPresenter() {
        mPresenter = new OderConfirmPresenter(getActivity(), this);
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlPartView.setLayoutManager(linearLayoutManager);
        mAdapter = new ItemPartAdapter(getContext(), R.layout.item_confirm_part);
        rlPartView.setAdapter(mAdapter);
        rlPartView.setNestedScrollingEnabled(false);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_confirm_order;
    }

    @Override
    public void ShowToast(String t) {
        showToast(t);
    }

    public void initData(CarInfo carInfo) {
        this.carInfo = carInfo;

        mPresenter.getPartsList(carInfo.carId);
        setText(tvCarCard, R.string.car_card_content, carInfo.carCard);
        setText(tvDriverName, R.string.car_driver_name_content, carInfo.driverName);
        setText(tvDriverPhone, R.string.car_driver_phone_content, carInfo.driverPhone);
        carInfo.acceptTime = DateTimeUtils.millisecondToDate(System.currentTimeMillis(), DateTimeUtils.YYYY_MM_DD_HH_MM);
        setText(tvAcceptTime, R.string.car_accept_time, carInfo.acceptTime);
        tvRepairDetail.setText(carInfo.maintenanceDetail);

        setText(tvDutyPerson, R.string.car_duty_person_content, carInfo.dutyPerson);
        setText(tvRepairTime, R.string.car_repair_time_content, Utils.getFinalCashValue(carInfo.workTime));
        setText(tvTimeFee, R.string.car_repair_fee_content, Utils.getFinalCashValue(carInfo.workPrice));

    }

    private void setText(TextView tvView, int resId, String content) {
        tvView.setText(String.format(getString(resId), content));
    }

    @Override
    public void getCarPartsList(List<CarPartsInfo> responses) {
        double totalPartPrice = 0;
        if (responses != null && responses.size() > 0) {
            mAdapter.updateWithClear(responses);
            for (CarPartsInfo carpart : responses
            ) {
                totalPartPrice += carpart.partCount * Double.valueOf(carpart.partPrice);
            }
        } else {
            rlPartView.setVisibility(View.GONE);
        }
        double totalPrice = carInfo.workTime * carInfo.workPrice + totalPartPrice;
        setText(tvTotalFee, R.string.part_price, Utils.getFinalCashValue(totalPrice));

    }
}
