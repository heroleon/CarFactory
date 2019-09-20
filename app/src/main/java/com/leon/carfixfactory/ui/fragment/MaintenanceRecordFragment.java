package com.leon.carfixfactory.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.leon.carfixfactory.R;
import com.leon.carfixfactory.bean.CarPartsInfo;
import com.leon.carfixfactory.bean.ItemEditContent;
import com.leon.carfixfactory.contract.ItemEditTextContact;
import com.leon.carfixfactory.presenter.EditContentImp;
import com.leon.carfixfactory.ui.activity.WorkerManageActivity;
import com.leon.carfixfactory.ui.adapter.CarPartsAdapter;
import com.leon.carfixfactory.ui.adapter.base.BaseRecyclerAdapter;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;


import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

public class MaintenanceRecordFragment extends BaseFragment<EditContentImp> implements ItemEditTextContact.ViewEditContent {

    private static final int DUTY_PERSON = 1000;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.rl_parts_list)
    RecyclerView rlParts;
    private CarPartsAdapter mAdapter;

    @Override
    protected void initPresenter() {
        mPresenter = new EditContentImp(getActivity(), this);
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlParts.setLayoutManager(linearLayoutManager);
        mAdapter = new CarPartsAdapter(getContext(), R.layout.item_car_part);
        rlParts.setAdapter(mAdapter);
        mAdapter.setOnDelClickListener(new CarPartsAdapter.OnDelClickListener() {
            @Override
            public void onDelete(int position) {
                mAdapter.delete(position);
            }
        });

        mAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position) {
                showFileEditDialog(mAdapter.getItems(position), position);
            }
        });
    }

    @OnClick(value = {R.id.ll_repair_duty_person, R.id.iv_add_part})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_repair_duty_person:
                Intent intent = new Intent(getContext(), WorkerManageActivity.class);
                startActivityForResult(intent, DUTY_PERSON);
                break;
            case R.id.iv_add_part:
                showFileEditDialog(null, -1);
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_maintenance_content;
    }


    @Override
    public void ShowToast(String t) {
        showToast(t);
    }

    @Override
    public void getItemDataSuccess(List<ItemEditContent> responses) {

    }

    private void showFileEditDialog(final CarPartsInfo carPartsInfo, final int position) {
        final InputMethodManager inputMethodManager = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        QMUIDialog.CustomDialogBuilder builder = new QMUIDialog.CustomDialogBuilder(getContext());
        builder.setLayout(R.layout.dialog_add_car_part);
        QMUIDialog dialog = builder
                .addAction(0, getResources().getString(R.string.cancel), QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog1, int index) {
                        dialog1.dismiss();
                    }
                })
                .addAction(0, getResources().getString(R.string.confirm), QMUIDialogAction.ACTION_PROP_POSITIVE, new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog12, int index) {
                        AppCompatEditText editName = dialog12.findViewById(R.id.et_part_name);
                        String partName = editName.getText().toString().trim();
                        AppCompatEditText editPrice = dialog12.findViewById(R.id.et_part_price);
                        String partPrice = editPrice.getText().toString().trim();
                        AppCompatEditText editCount = dialog12.findViewById(R.id.et_part_count);
                        String partCount = editCount.getText().toString().trim();
                        if (TextUtils.isEmpty(partName)) {
                            showToast(getString(R.string.notify_input_part_name));
                            return;
                        }
                        if (TextUtils.isEmpty(partPrice)) {
                            showToast(getString(R.string.notify_input_part_price));
                            return;
                        }
                        if (TextUtils.isEmpty(partCount)) {
                            showToast(getString(R.string.notify_input_part_count));
                            return;
                        }
                        if (carPartsInfo != null) {
                            carPartsInfo.partName = partName;
                            carPartsInfo.partCount = Integer.valueOf(partCount);
                            carPartsInfo.partPrice = partPrice;
                            mAdapter.update(carPartsInfo, position);
                        } else {
                            CarPartsInfo partsInfo = new CarPartsInfo();
                            partsInfo.partName = partName;
                            partsInfo.partCount = Integer.valueOf(partCount);
                            partsInfo.partPrice = partPrice;
                            mAdapter.addItem(partsInfo);
                        }
                        dialog12.dismiss();
                    }
                })
                .create(R.style.dialog_theme);
        final AppCompatEditText editName = dialog.findViewById(R.id.et_part_name);
        AppCompatEditText editPrice = dialog.findViewById(R.id.et_part_price);
        AppCompatEditText editCount = dialog.findViewById(R.id.et_part_count);
        if (carPartsInfo != null) {
            editPrice.setText(carPartsInfo.partPrice);
            editName.setText(carPartsInfo.partName);
            editName.setSelection(carPartsInfo.partName.length());
            editCount.setText(String.valueOf(carPartsInfo.partCount));
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog13) {
                inputMethodManager.hideSoftInputFromWindow(editName.getWindowToken(), 0);
            }
        });
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog14) {
                editName.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        inputMethodManager.showSoftInput(editName, 0);
                    }
                }, 300);
            }
        });
        dialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == DUTY_PERSON) {
                if (data != null) {
                    String dutyPersonName = data.getStringExtra("duty_person");
                    tvRight.setText(dutyPersonName);
                }
            }
        }
    }
}
