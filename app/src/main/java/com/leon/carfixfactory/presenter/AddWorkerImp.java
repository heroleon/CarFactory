package com.leon.carfixfactory.presenter;

import android.app.Activity;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.leon.carfixfactory.bean.ItemEditContent;
import com.leon.carfixfactory.contract.AddWorkerContact;
import java.util.ArrayList;

public class AddWorkerImp extends BasePresenter<AddWorkerContact.ViewAddWorker> implements AddWorkerContact.IAddWorker {

    public AddWorkerImp(Activity context, AddWorkerContact.ViewAddWorker view){
        super(context,view);
    }

    @Override
    public void initItemData(String fileName) {
        ArrayList<ItemEditContent> mDataList = new ArrayList<>();
        String strByJson = getJson(fileName);
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(strByJson).getAsJsonArray();
        Gson gson = new Gson();

        for (JsonElement indexArr : jsonArray) {
            ItemEditContent menuEntity = gson.fromJson(indexArr, ItemEditContent.class);
            mDataList.add(menuEntity);
        }
        mView.getItemDataSuccess(mDataList);
    }


}
