package com.dajiabao.readsource;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wangc on 2018/8/8
 * E-MAIL:274281610@QQ.COM
 */
public class MyView extends View {

    private int length ;
    private Paint mPaint ;
    private float value;

    public MyView(Context context) {
        super(context);
        init();
    }



    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init(){
        setClipToOutline(true);
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.STROKE);
        startDraw();
    }

    public void  setLength(int length){
        this.length = length;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        int widthFinal = 0;
        int heightFinal = 0;

        if (widthMode == MeasureSpec.AT_MOST){
            if (width<100){
                widthFinal = 200;
            }else {
                widthFinal = width;
                heightFinal = height;
            }
        }else if (widthMode == MeasureSpec.EXACTLY){
            widthFinal = 400;
            heightFinal = 400;
        }

        setMeasuredDimension(widthFinal,heightFinal);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawLine(0,50,value,50,mPaint);
//        canvas.drawCircle(110,100+value,100,mPaint);

        Path path = new Path();
        path.moveTo(0,0);
        path.rQuadTo(300,300,-300,-300);
        path.rQuadTo(0,0,330,-200);

        canvas.drawPath(path,mPaint);

    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
    }


    public void  startDraw(){
         ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,this.length,0).setDuration(3000);
         valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
             @Override
             public void onAnimationUpdate(ValueAnimator animation) {
                 value = (float) animation.getAnimatedValue();


                 postInvalidate();
             }
         });
         valueAnimator.setRepeatMode(ValueAnimator.RESTART);
         valueAnimator.setRepeatCount(10);
         valueAnimator.start();

    }
}
