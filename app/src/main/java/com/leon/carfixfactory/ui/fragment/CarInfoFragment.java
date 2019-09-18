package com.leon.carfixfactory.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leon.carfixfactory.R;
import com.leon.carfixfactory.bean.HomeData;
import com.leon.carfixfactory.contract.HomeContact;
import com.leon.carfixfactory.presenter.HomeDataPresenterImp;

import java.util.List;

public class CarInfoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car_info, container, false);
    }
}
