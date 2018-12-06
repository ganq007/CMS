package com.tms.geq.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tms.geq.myapplication.utils.IPUtils;

public class IPSettingActivity  extends Activity implements View.OnClickListener {

    private EditText mIp1;
    private EditText mIp2;
    private EditText mIp3;
    private EditText mIp4;
    private Button mMake;
    private Button mCenale;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_setting);
        initView();
    }

    //初始化控件
    private void initView() {
        mIp1 = findViewById(R.id.ip1);
        mIp2 = findViewById(R.id.ip2);
        mIp3 = findViewById(R.id.ip3);
        mIp4 = findViewById(R.id.ip4);
        mMake = findViewById(R.id.ip_but_make);
        mCenale = findViewById(R.id.ip_but_cenale);

        //按钮点击事件
        mMake.setOnClickListener(this);
        mCenale.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.ip_but_make://确定
                String ip = getIP();
                boolean flag = IPUtils.ipCheck(ip);
                if (flag){
                    Toast.makeText(this, "设置成功！", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "设置异常，srroy ！", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.ip_but_cenale://取消
                Intent intent = new Intent(IPSettingActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    //获取ip地址
    private String getIP() {
        String ip1 = mIp1.getText().toString().trim();
        String ip2 = mIp2.getText().toString().trim();
        String ip3 = mIp3.getText().toString().trim();
        String ip4 = mIp4.getText().toString().trim();
        String ip = ip1+"."+ip2+"."+ip3+"."+ip4;
        return  ip;
    }


}
