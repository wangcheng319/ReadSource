package com.dajiabao.moudle2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dajiabao.readsource.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Route(path = "/modeul2/Moudle2MainActivity")
public class Moudle2MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moudle2_main);
        Log.e("+++","这里是module2");

        EventBus.getDefault().register(this);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ARouter.getInstance().build("/module3/Module3Activity").navigation();
                MessageEvent stickyEvent = EventBus.getDefault().getStickyEvent(MessageEvent.class);
                Log.e("+++","哈哈："+stickyEvent);
                if(stickyEvent != null) {
                    EventBus.getDefault().removeStickyEvent(stickyEvent);
                }
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTest(MessageEvent messageEvent){
        Log.e("+++","方法名测试3："+messageEvent.message);
    }
}
