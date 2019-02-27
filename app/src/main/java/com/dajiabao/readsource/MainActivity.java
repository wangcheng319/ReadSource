package com.dajiabao.readsource;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LifecycleObserver;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.haha.perflib.Main;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
//    @Autowired
//    public String back;
    @BindView(R.id.btn)
    Button button;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        LocalBroadcastManager.getInstance(this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(MainActivity.this,"本地广播"+intent.getStringExtra("key"),Toast.LENGTH_SHORT).show();
                Log.e("+++","本地广播"+intent.getStringExtra("key"));
            }
        },new IntentFilter());
        EventBus.getDefault().register(this);

//        ARouter.getInstance().inject(this);
        /*应用内跳转*/
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.e("+++","点击跳转");
//                EventBus.getDefault().post(new MessageEvent("普通事件"));
                ARouter.getInstance().build("/test/Main2Activity").withString("key","value").navigation();
                EventBus.getDefault().postSticky(new MessageEvent("粘性事件"));

            }
        });

        /*跨应用跳转*/
        findViewById(R.id.btn1).setOnClickListener(View->{
            ARouter.getInstance().build("/modeul2/Moudle2MainActivity").navigation();
//            EventBus.getDefault().postSticky(new MessageEvent("粘性事件"));
            EventBus.getDefault().post(new MessageEvent("普通事件"));
        });


        Executors.newFixedThreadPool(5).submit(new Runnable() {
            @Override
            public void run() {
                Log.e("+++","");
            }
        });

        Button button = new Button(this);
        button.animate().translationX(1).setDuration(1000).start();


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTest(MessageEvent messageEvent){
        Log.e("+++","方法名测试1："+messageEvent.message);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        new MyTask().execute();
    }

    class  MyTask extends AsyncTask{



        @Override
        protected Object doInBackground(Object[] objects) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Object o) {
            super.onCancelled(o);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }
}
