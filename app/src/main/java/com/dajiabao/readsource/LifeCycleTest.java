package com.dajiabao.readsource;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;
import android.widget.NumberPicker;

/**
 * Created by wangc on 2018/10/31
 * E-MAIL:274281610@QQ.COM
 */
public interface LifeCycleTest extends LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
     void onCreate();


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume();

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
     void onDestory();

}
