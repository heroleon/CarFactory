package com.leon.carfixfactory.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leon.carfixfactory.MyApplication;
import com.leon.carfixfactory.R;
import com.leon.carfixfactory.bean.ItemEditContent;
import com.leon.carfixfactory.bean.WorkerInfo;
import com.leon.carfixfactory.contract.AddWorkerContact;
import com.leon.carfixfactory.presenter.AddWorkerImp;
import com.leon.carfixfactory.utils.ContentViewSetting;
import com.leon.carfixfactory.utils.GlideUtils;
import com.winfo.photoselector.PhotoSelector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class AddWorkerActivity extends BaseActivity<AddWorkerImp> implements AddWorkerContact.ViewAddWorker {
    private static final int PHOTO_CODE = 10000;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ll_name)
    LinearLayout llName;
    @Bind(R.id.ll_birthday)
    LinearLayout llBirthday;
    @Bind(R.id.ll_phone)
    LinearLayout llPhone;
    @Bind(R.id.ll_address)
    LinearLayout llAddress;
    @Bind(R.id.iv_worker_avatar)
    ImageView ivWorkerAvatar;

    private View[] views;

    @Override
    protected void initPresenter(Intent intent) {
        mPresenter = new AddWorkerImp(this, this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_add_worker;
    }

    @Override
    protected void initView() {
        tvTitle.setText(getString(R.string.title_add_worker));
        views = new View[]{llName, llBirthday, llPhone, llAddress};
        mPresenter.initItemData("itemAddWorker.json");
    }

    @OnClick(value = {R.id.iv_back, R.id.btn_confirm, R.id.rl_avatar})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_avatar:
                choosePhoto();
                break;
            case R.id.btn_confirm:
                WorkerInfo workerInfo = new WorkerInfo();
                workerInfo.workerName = ContentViewSetting.getEditTextContent(llName);
                workerInfo.workerBirthDay = ContentViewSetting.getEditTextContent(llBirthday);
                workerInfo.workerPhone = ContentViewSetting.getEditTextContent(llPhone);
                workerInfo.workerAddress = ContentViewSetting.getEditTextContent(llAddress);
                String errNotify = workerInfo.checkData(this);
                if (TextUtils.isEmpty(errNotify)) {
                    MyApplication.getApplication().getDaoSession().getWorkerInfoDao().insert(workerInfo);
                } else {
                    showToast(errNotify);
                }
                break;
        }
    }

    private void choosePhoto() {
        PhotoSelector.builder()
                .setShowCamera(true)//显示拍照
                .setMaxSelectCount(1)//最大选择9 默认9，如果这里设置为-1则是不限数量
                .setGridColumnCount(3)//列数
                .setMaterialDesign(true)//design风格
                .setToolBarColor(ContextCompat.getColor(this, R.color.colorPrimary))//toolbar的颜色
                .setBottomBarColor(ContextCompat.getColor(this, R.color.colorPrimary))//底部bottombar的颜色
                .setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary))//状态栏的颜色
                .start(this, PHOTO_CODE);
    }

    @Override
    public void getItemDataSuccess(List<ItemEditContent> responses) {
        for (int i = 0; i < responses.size(); i++) {
            ContentViewSetting.setItemContent(views[i], responses.get(i));
        }
    }

    @Override
    public void ShowToast(String t) {
        showToast(t);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PHOTO_CODE) {
            if(data!=null){
                ArrayList<String> imgs =  data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                GlideUtils.loadCenterCropCircleImage(this,imgs.get(0),ivWorkerAvatar);
            }
        }
    }
}
