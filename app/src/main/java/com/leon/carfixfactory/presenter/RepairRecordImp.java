package com.leon.carfixfactory.presenter;

import android.app.Activity;

import com.leon.carfixfactory.MyApplication;
import com.leon.carfixfactory.bean.CarInfo;
import com.leon.carfixfactory.bean.WorkerInfo;
import com.leon.carfixfactory.beanDao.CarInfoDao;
import com.leon.carfixfactory.beanDao.WorkerInfoDao;
import com.leon.carfixfactory.contract.RepairRecordContact;
import com.leon.carfixfactory.contract.WorkerManageContact;

import java.util.List;

public class RepairRecordImp extends BasePresenter<RepairRecordContact.ViewRepairRecord> implements RepairRecordContact.IRepairRecordPresenter {
    public RepairRecordImp(Activity context, RepairRecordContact.ViewRepairRecord view) {
        super(context, view);
    }

    @Override
    public void getRepairRecordData() {
        CarInfoDao carInfoDao = MyApplication.getApplication().getDaoSession().getCarInfoDao();
        List<CarInfo> carInfos = carInfoDao.loadAll();
        mView.getRepairRecordSuccess(carInfos);
    }
}
