package com.dajiabao.readsource;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangc on 2018/9/28
 * E-MAIL:274281610@QQ.COM
 */
public class MySearchView extends ViewGroup {
    //偏移量
    private static final  int OFFSET = 100;

    public MySearchView(Context context) {
        super(context);
    }

    public MySearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e("+++","onLayout");
        int top = 0;
        int left = 0;
        int right = 0;
        int bottom = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            left = i*OFFSET;
            right = left + child.getMeasuredWidth();
            bottom = top +child.getMeasuredHeight();


            child.layout(left,top,right,bottom);

            top += child.getMeasuredHeight();
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("+++","onMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode  = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        //最终测量出来的高度
        int measureWidth = 0;
        //最终测量出来的宽度
        int measureHeight = 0;

        //子控件数
        int childCount = getChildCount();

        //测量全部子控件
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            LayoutParams layoutParams = child.getLayoutParams();
            int childWMeasureSpec = getChildMeasureSpec(widthMeasureSpec,0,layoutParams.width);
            int childHMeasureSpec = getChildMeasureSpec(heightMeasureSpec,0,layoutParams.height);

            //子控件测量自身
            child.measure(childWMeasureSpec,childHMeasureSpec);
        }

        //宽度
        switch (widthMode){
            case MeasureSpec.EXACTLY:
                measureWidth = width;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                for (int i = 0; i < childCount; i++) {
                    View child = getChildAt(i);
                    int widthAndOffset = i*OFFSET+child.getMeasuredWidth();
                    measureWidth = Math.max(measureWidth,widthAndOffset);
                }
                break;
        }

        //高度
        switch (heightMode){
            case MeasureSpec.EXACTLY:
                measureHeight = height;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                for (int i = 0; i < childCount; i++) {
                    View child = getChildAt(i);
                    measureHeight +=  child.getMeasuredHeight();
                }
                break;
        }

        //设置最终测量宽高
        setMeasuredDimension(measureWidth,measureHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("+++","onDraw");
    }
}
