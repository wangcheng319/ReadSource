package com.dajiabao.readsource;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dajiabao.readsource.databinding.ActivityDataBindViewModelBinding;

import viewmodel.FirstViewModel;

/**
 * DataBind+ViewModel
 */
public class DataBindViewModelActivity extends AppCompatActivity {
    private ActivityDataBindViewModelBinding bindViewModelBinding;
    private FirstViewModel firstViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_bind_view_model);

        bindViewModelBinding = DataBindingUtil.setContentView(this,R.layout.activity_data_bind_view_model);
        firstViewModel = ViewModelProviders.of(this).get(FirstViewModel.class);
        bindViewModelBinding.setViewmodel(firstViewModel);


        firstViewModel.lastname.set("hehehh");

        //改变绑定值
        findViewById(R.id.getname).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstViewModel.lastname.set("张三");
            }
        });

        //改变绑定值
        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstViewModel.setName();
            }
        });

    }
}
