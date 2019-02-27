package com.dajiabao.readsource;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class RecyclerViewTestActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter ;

    int findLastVisibleItemPosition = 0;
    int firstVisibleItemPositiont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_test);

        Log.e("wangc","activity:onCreate");
        recyclerView = findViewById(R.id.rv);
        List datas = new ArrayList();
        Flowable.range(1,60).subscribe(integer -> {
            datas.add(""+integer);

        });
        myAdapter = new MyAdapter(this,datas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(myAdapter);

        recyclerView.setLayoutManager(linearLayoutManager);


    }
}
