package com.leon.carfixfactory.contract;

import com.leon.carfixfactory.bean.CarInfo;
import com.leon.carfixfactory.ui.view.IBaseView;

import java.util.List;

public interface RepairRecordContact {
    interface ViewRepairRecord extends IBaseView {
        void getRepairRecordSuccess(List<CarInfo> responses);
    }

    interface IRepairRecordPresenter {
        void getRepairRecordData();
    }
}
