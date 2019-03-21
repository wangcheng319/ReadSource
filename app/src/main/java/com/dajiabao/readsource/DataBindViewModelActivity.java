package com.dajiabao.readsource;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dajiabao.readsource.databinding.ActivityDataBindViewModelBinding;

import java.util.concurrent.locks.ReentrantLock;

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

//                firstViewModel.setName();
                LockTest lockTest = new LockTest();
                Thread thread = new Thread(lockTest,"Thread 1");
                Thread thread1 = new Thread(lockTest,"Thread 2");
                Thread thread2 = new Thread(lockTest,"Thread 3");
                thread.start();
                thread1.start();
                thread2.start();

            }
        });

    }

    public static  class LockTest implements  Runnable{

        public  ReentrantLock reentrantLock = new ReentrantLock(true);
        public static   int a = 20;

        @Override
        public void run() {
           while (a>0){
               try {
                   reentrantLock.lock();
                   Log.i("+++", "run: "+Thread.currentThread().getName()+"---"+a);
                   a--;
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }finally {
                   reentrantLock.unlock();
               }

           }
        }
    }
}
