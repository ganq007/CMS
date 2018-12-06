package com.tms.geq.myapplication.view;

import android.content.Context;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.tms.geq.myapplication.utils.LogUtils;


public class MySlidingMenu extends ViewGroup {

    private View menuViwe;
    private View mainViwe;
    private int downX;
    private int moveX;
    private int distance;
    private int width;
    private int nextStarIndx;

    public MySlidingMenu(Context context) {
      //  super(context);
        this(context,null);
    }

    public MySlidingMenu(Context context, AttributeSet attrs) {
       // super(context, attrs);
        this(context,null,-1);
    }

    public MySlidingMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //测量宽高
    //1 . 自定义控件的宽高 ， 首页宽高 ，菜单页宽高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       // 1 自定义控件
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取子控件
        menuViwe = getChildAt(0);
        mainViwe = getChildAt(1);
        //2 . 首页测量,默认
        mainViwe.measure(widthMeasureSpec,heightMeasureSpec);
        //3 .菜单页宽高
        width = menuViwe.getLayoutParams().width;
        menuViwe.measure(240,heightMeasureSpec);


    }

    //l, t, b ()相对应父控件的距离
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //排版
        mainViwe.layout(l,t,r,b);
        menuViwe.layout(l-240,t,r,b);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                //按下x轴坐标
                downX = (int) event.getX();
                LogUtils.loge("按下x轴坐标");
                break;
            case  MotionEvent.ACTION_MOVE:
                //抬起x轴坐标
                moveX = (int) event.getX();
                //获取移动的距离
                distance = nextStarIndx + moveX - downX;
                //控制滑动的范围
                if (distance<0){
                    distance = 0;
                }else if (distance>width){
                    distance = width;
                }
                //设置移动距离
                myscrollTo(distance);
                break;
            case  MotionEvent.ACTION_UP:
                nextStarIndx = distance;
                break;
        }
        return true;
    }

    private void myscrollTo(int distance) {
        scrollTo(-distance,0);
    }
}
