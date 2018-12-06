package com.tms.geq.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.tms.geq.myapplication.utils.AnalysisJSONUtils;
import com.tms.geq.myapplication.utils.Constants;
import com.tms.geq.myapplication.utils.HttpUtils;
import com.tms.geq.myapplication.utils.InternetUtils;
import com.tms.geq.myapplication.vo.GetAllSense;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView mP25AndWendu;
    private TextView mBus1JuLi;
    private TextView mShiDu;
    private TextView mBus2JuLi;
    private boolean netWorkAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //网络连接
        netWorkAvailable = InternetUtils.isNetWorkAvailable(this);
        //初始化控件
        initView();
    }
    //初始化控件
    private void initView() {
        mP25AndWendu = findViewById(R.id.home_pm25andtemp);
        mBus1JuLi = findViewById(R.id.home_bus1_juli);
        mShiDu = findViewById(R.id.home_shidu);
        mBus2JuLi = findViewById(R.id.home_bus2_juli);
    }

    @Override
    protected void onStart() {
        //判断网络连接进入界面初始化网络数据
        if (netWorkAvailable){
            setHomeData();
        }
        super.onStart();
    }

    //设置主页显示数据
    private void setHomeData() {
        new Thread(){
            @Override
            public void run() {
                String json = HttpUtils.doPost(Constants.HTTP + Constants.HTTPGETALLSENSE, null);
                final GetAllSense getAllSense = AnalysisJSONUtils.getGetAllSense(json);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int pm25 = getAllSense.pm25;
                        int co2 = getAllSense.co2;
                        int temperature = getAllSense.temperature;
                        int lightIntensity = getAllSense.LightIntensity;
                        int humidity = getAllSense.humidity;
                        mP25AndWendu.setText("PM 2.5 :"+pm25+" 100up/m2  , \t 温度 :"+temperature+"C^");
                        mShiDu.setText("湿度: "+humidity+", \tCo2: "+co2+" m2");
                    }
                });
            }
        }.start();
    }







    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.mycar) {
            //我的座驾
            Intent intent = new Intent(MainActivity.this,MyCarActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_sdsd) {

        } else if (id == R.id.nav_send) {
            Intent intent  = new Intent(MainActivity.this,IPSettingActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
