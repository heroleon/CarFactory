package com.leon.carfixfactory.presenter;

import android.app.Activity;

import com.leon.carfixfactory.MyApplication;
import com.leon.carfixfactory.bean.CarPartsInfo;
import com.leon.carfixfactory.bean.WorkerInfo;
import com.leon.carfixfactory.beanDao.CarPartsInfoDao;
import com.leon.carfixfactory.beanDao.WorkerInfoDao;
import com.leon.carfixfactory.contract.HomeContact;
import com.leon.carfixfactory.contract.OrderConfirmContact;

import java.util.List;

/**
 * Created by leon
 * Date: 2019/9/21
 * Time: 10:54
 * Desc:
 */
public class OderConfirmPresenter extends BasePresenter<OrderConfirmContact.ViewOrderConfirm> implements OrderConfirmContact.IOrderConfirmPresenter {

    public OderConfirmPresenter(Activity context, OrderConfirmContact.ViewOrderConfirm view) {
        super(context, view);
    }

    @Override
    public void getPartsList(Long carId) {
        CarPartsInfoDao carPartsInfoDao = MyApplication.getApplication().getDaoSession().getCarPartsInfoDao();
        List<CarPartsInfo> carPartsInfos = carPartsInfoDao.queryBuilder()
                .where(CarPartsInfoDao.Properties.CarId.eq(carId))
                .build().list();
        mView.getCarPartsList(carPartsInfos);
    }
}
