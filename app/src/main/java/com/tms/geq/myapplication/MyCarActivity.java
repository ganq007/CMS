package com.tms.geq.myapplication;

import android.app.Activity;
import android.os.Bundle;

public class MyCarActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_car);
        initView();
    }

    //初始化控件
    private void initView() {

    }

}
