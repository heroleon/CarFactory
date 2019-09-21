package com.leon.carfixfactory.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.leon.carfixfactory.R;
import com.leon.carfixfactory.bean.CarInfo;
import com.leon.carfixfactory.bean.HomeData;
import com.leon.carfixfactory.bean.ItemEditContent;
import com.leon.carfixfactory.contract.HomeContact;
import com.leon.carfixfactory.contract.ItemEditTextContact;
import com.leon.carfixfactory.presenter.EditContentImp;
import com.leon.carfixfactory.presenter.HomeDataPresenterImp;
import com.leon.carfixfactory.ui.activity.MaintenanceRecordActivity;
import com.leon.carfixfactory.utils.ContentViewSetting;

import java.util.List;

import butterknife.Bind;

public class CarInfoFragment extends BaseFragment<EditContentImp> implements ItemEditTextContact.ViewEditContent {
    @Bind(R.id.ll_car_id)
    LinearLayout llCarId;
    @Bind(R.id.ll_chassis_num)
    LinearLayout llChassisNum;
    @Bind(R.id.ll_engine_num)
    LinearLayout llEngineNum;

    @Bind(R.id.ll_driver_name)
    LinearLayout llDriverName;
    @Bind(R.id.ll_driver_card)
    LinearLayout llDriverCard;
    @Bind(R.id.ll_driver_phone)
    LinearLayout llDriverPhone;

    @Bind(R.id.ll_department_name)
    LinearLayout llDepName;
    @Bind(R.id.ll_department_address)
    LinearLayout llDepAddr;
    @Bind(R.id.ll_department_phone)
    LinearLayout llDepPhone;

    private View[] views;

    @Override
    protected void initPresenter() {
        mPresenter = new EditContentImp(getActivity(), this);
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        views = new View[]{llCarId, llChassisNum, llEngineNum,
                llDriverName, llDriverCard, llDriverPhone,
                llDepName, llDepAddr, llDepPhone};
        mPresenter.initItemData("itemCarInfo.json");
    }

    public boolean checkEmptyData(CarInfo carInfo) {
        carInfo.carCard = ContentViewSetting.getEditTextContent(llCarId);
        carInfo.chassisNum = ContentViewSetting.getEditTextContent(llChassisNum);
        carInfo.engineNum = ContentViewSetting.getEditTextContent(llEngineNum);
        carInfo.driverName = ContentViewSetting.getEditTextContent(llDriverName);
        carInfo.driverIdcard = ContentViewSetting.getEditTextContent(llDriverCard);
        carInfo.driverPhone = ContentViewSetting.getEditTextContent(llDriverPhone);
        carInfo.departmentName = ContentViewSetting.getEditTextContent(llDepName);
        carInfo.departmentAddr = ContentViewSetting.getEditTextContent(llDepAddr);
        carInfo.departmentPhone = ContentViewSetting.getEditTextContent(llDepPhone);
        return carInfo.checkData(getActivity());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_car_info;
    }

    @Override
    public void ShowToast(String t) {
        showToast(t);
    }

    @Override
    public void getItemDataSuccess(List<ItemEditContent> responses) {
        for (int i = 0; i < responses.size(); i++) {
            ContentViewSetting.setItemContent(views[i], responses.get(i));
        }
    }

    public void initData(CarInfo carInfo) {
        if (carInfo != null) {
            ContentViewSetting.setEditTextContent(llCarId, carInfo.carCard);
            ContentViewSetting.setEditTextContent(llChassisNum, carInfo.chassisNum);
            ContentViewSetting.setEditTextContent(llEngineNum, carInfo.engineNum);
            ContentViewSetting.setEditTextContent(llDriverName, carInfo.driverName);
            ContentViewSetting.setEditTextContent(llDriverCard, carInfo.driverIdcard);
            ContentViewSetting.setEditTextContent(llDriverPhone, carInfo.driverPhone);
            ContentViewSetting.setEditTextContent(llDepName, carInfo.departmentName);
            ContentViewSetting.setEditTextContent(llDepAddr, carInfo.departmentAddr);
            ContentViewSetting.setEditTextContent(llDepPhone, carInfo.departmentPhone);
        }
    }
}
