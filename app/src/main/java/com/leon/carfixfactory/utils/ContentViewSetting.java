package com.leon.carfixfactory.utils;

import android.support.v7.widget.AppCompatEditText;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.leon.carfixfactory.R;
import com.leon.carfixfactory.bean.ItemEditContent;

public class ContentViewSetting {
    public static void setItemContent(View view, ItemEditContent itemContent) {
        TextView leftTitle = view.findViewById(R.id.tv_left_title);
        ImageView ivMustShow = view.findViewById(R.id.iv_necessary_star);
        AppCompatEditText etContent = view.findViewById(R.id.et_content);
        leftTitle.setText(itemContent.title);
        int visible = itemContent.must ? View.VISIBLE : View.GONE;
        ivMustShow.setVisibility(visible);
        etContent.setInputType(itemContent.inputType);
        etContent.setHint(itemContent.hint);
        etContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(itemContent.maxLength) {
        }});
    }

    public static String getEditTextContent(View view) {
        AppCompatEditText etContent = view.findViewById(R.id.et_content);
        return etContent.getText() == null ? null : etContent.getText().toString();
    }
}
