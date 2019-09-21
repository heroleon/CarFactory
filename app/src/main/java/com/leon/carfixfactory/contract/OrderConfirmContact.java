package com.leon.carfixfactory.contract;

import com.leon.carfixfactory.bean.CarPartsInfo;
import com.leon.carfixfactory.bean.HomeData;
import com.leon.carfixfactory.ui.view.IBaseView;

import java.util.List;

/**
 * Created by leon
 * Date: 2019/9/21
 * Time: 10:52
 * Desc:确认维修单
 */
public class OrderConfirmContact {
    public interface ViewOrderConfirm extends IBaseView {
        void getCarPartsList(List<CarPartsInfo> responses);
    }

    public interface IOrderConfirmPresenter {
        void getPartsList(Long carId);
    }
}
