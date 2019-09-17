package com.leon.carfixfactory.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by leon
 * Date: 2019/9/17
 * Time: 16:19
 * Desc:
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
