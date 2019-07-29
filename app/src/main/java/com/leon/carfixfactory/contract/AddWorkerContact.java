package com.leon.carfixfactory.contract;

import com.leon.carfixfactory.bean.ItemEditContent;
import com.leon.carfixfactory.ui.view.IBaseView;

import java.util.List;

/**
 * Created by leon
 * Date: 2019/7/25
 * Time: 10:01
 * Desc:添加工人
 */
public interface  AddWorkerContact {

    interface  ViewAddWorker extends IBaseView {
        void getItemDataSuccess(List<ItemEditContent> responses);
    }
    interface IAddWorker{
        void initItemData(String fileName);
    }
}
