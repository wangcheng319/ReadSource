package com.dajiabao.readsource;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class DrableTestActivity extends Activity {
    ImageView imageView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drable_test);
        imageView = findViewById(R.id.iv);
        frameLayout = findViewById(R.id.fl);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setClipToOutline(true);
                imageView.setOutlineProvider(new ViewOutlineProvider() {
                    @Override
                    public void getOutline(View view, Outline outline) {
                        int margin = Math.min(view.getWidth(), view.getHeight()) / 50;
                        outline.setOval(0, 0, view.getWidth(), view.getHeight());
                        outline.setAlpha(0.5f);
                    }
                });

                frameLayout.setClipToOutline(true);
                frameLayout.setOutlineProvider(new ViewOutlineProvider() {
                    @Override
                    public void getOutline(View view, Outline outline) {
//                        outline.setOval(0,0,view.getWidth(),view.getHeight());
                        outline.setRoundRect(5,5,view.getWidth(),view.getHeight(),30);
                    }
                });
            }
        });

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLayout.setClipToOutline(true);
                frameLayout.setOutlineProvider(new ViewOutlineProvider() {
                    @Override
                    public void getOutline(View view, Outline outline) {
//                        outline.setOval(0,0,view.getWidth(),view.getHeight());
//                        outline.setRoundRect(5,5,view.getWidth(),view.getHeight(),30);
                        outline.setEmpty();
                    }
                });
            }
        });
    }
}
