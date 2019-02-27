package com.dajiabao.readsource;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.support.v4.util.LruCache;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;



/**
 * Created by wangc on 2018/9/25
 * E-MAIL:274281610@QQ.COM
 */
public class MySeekBar extends View {

    private Paint mPanit;

    private Paint mPaint2;

    private float progress = 30;

    public MySeekBar(Context context) {
        super(context);
    }

    public MySeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint(attrs);
    }

    private void initPaint(AttributeSet attrs) {
        //获得所有的属性
        TypedArray array=getContext().obtainStyledAttributes(attrs,R.styleable.MySeekBar);
        progress=array.getInteger(R.styleable.MySeekBar_progress,0);

        SweepGradient sweepGradient = new SweepGradient(100, 100, 0x00FF0000, 0xFF0000FF);

        mPanit = new Paint();
        mPanit.setColor(Color.RED);
        mPanit.setShader(sweepGradient);
        mPanit.setStrokeWidth(40);
        mPanit.setStyle(Paint.Style.STROKE);
        mPanit.setStrokeCap(Paint.Cap.ROUND);


        mPaint2 = new Paint();
        mPaint2.setColor(Color.RED);
        mPaint2.setStrokeWidth(3);
        mPaint2.setStyle(Paint.Style.STROKE);
        mPaint2.setStrokeCap(Paint.Cap.ROUND);

        array.recycle();
    }

    @Override
    protected  void onDraw(Canvas canvas) {
        Log.e("+++","onDraw");
        float x = (getWidth() - getHeight() / 2) / 2;
        float y = getHeight() / 4;

        RectF oval = new RectF( x, y,
                getWidth() - x, getHeight() - y);
        canvas.drawArc(oval,120,progress,false,mPanit);

    }

    public float getProgress(){
        return progress;
    }

    public void setProgress(float mprogress) {
        if (mprogress == 0){
            progress = 0;
            postInvalidate();
            return;
        }

        if (progress == 330){
            setVisibility(View.GONE);
            postInvalidate();
            return;
        }

        Log.e("+++",""+mprogress);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(progress,mprogress);
        valueAnimator.setDuration(1*1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float a = (float) animation.getAnimatedValue();
                Log.e("+++",""+a);
                progress = a;
                postInvalidate();
            }
        });

        valueAnimator.start();

    }

}
