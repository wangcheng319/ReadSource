package com.dajiabao.readsource;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * 数据绑定   基本数据类
 */
import com.dajiabao.readsource.databinding.ActivityAutoSizeBinding;

public class DataBindTestActivity extends AppCompatActivity {
    private static final String TAG = "AutoSizeActivity";
    private ActivityAutoSizeBinding binding;
    private BindDto bindDto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ActivityAutoSizeBinding根据布局文件名生成
        binding = DataBindingUtil.setContentView(this,R.layout.activity_auto_size);

        bindDto = new BindDto();
        bindDto.name.set("zhangsan");
        binding.setBindDto(bindDto);

        //改变绑定值
        findViewById(R.id.getname).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindDto.name.set("张三");
                binding.setBindDto(bindDto);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState: ");
    }
}
