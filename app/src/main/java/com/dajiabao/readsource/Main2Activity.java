package com.dajiabao.readsource;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.media.MediaExtractor;
import android.nfc.NfcManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.transition.ChangeBounds;
import android.support.transition.ChangeTransform;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.util.LruCache;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dajiabao.moudle2.IMyAidlInterface;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.Executors;

import javax.microedition.khronos.egl.EGL;

import butterknife.BindView;
import butterknife.ButterKnife;


@Route(path = "/test/Main2Activity")
public class Main2Activity extends AppCompatActivity {
    @Autowired
    public String key;
    TextView textView;

    @BindView(R.id.iv)
    ImageView imageView;

    @BindView(R.id.lv)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        MediaExtractor mediaExtractor = new MediaExtractor();

        textView = findViewById(R.id.tv);
        findViewById(R.id.btn).setOnClickListener(v -> {
            ARouter.getInstance().build("/test/mainactivity").navigation();
            MessageEvent stickyEvent = EventBus.getDefault().getStickyEvent(MessageEvent.class);
            Log.e("+++","哈哈："+stickyEvent);
            if(stickyEvent != null) {
                EventBus.getDefault().removeStickyEvent(stickyEvent);
            }
        });
        ARouter.getInstance().inject(this);
        Log.e("+++",""+key);

        /**/
//        LeakThread leakThread = new LeakThread();
//        leakThread.start();

        ActivityManager activityManager = (ActivityManager) getSystemService(getApplication().ACTIVITY_SERVICE);

        IMyAidlInterface myAidlInterface = new IMyAidlInterface.Stub() {
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }
        };


        ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                IMyAidlInterface iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        Executors.newFixedThreadPool(3).submit(new Runnable() {
            @Override
            public void run() {
                try {
                    String url = "http://pic8.nipic.com/20100719/3320946_123936081858_2.jpg";
                    HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream(), 8 * 1024);
                    Bitmap bitmap = BitmapFactory.decodeStream(in);
                    urlConnection.disconnect();
                    in.close();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(bitmap);
                            imageView.setVisibility(View.GONE);
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        listView.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Arrays.asList("1","2","3")
        ));
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onTest(MessageEvent messageEvent){
        Log.e("+++","方法名测试2："+messageEvent.message);

    }

    @Override
    protected void onStop() {
        super.onStop();

        Intent intent = new Intent();
        intent.putExtra("key","local broad cast");
        LocalBroadcastManager.getInstance(Main2Activity.this).sendBroadcast(intent);

    }

    class LeakThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(6 * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

