package com.leon.carfixfactory.presenter;

import android.app.Activity;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.leon.carfixfactory.bean.ItemEditContent;
import com.leon.carfixfactory.contract.AddWorkerContact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    private String getJson(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assets = mContext.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assets.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
