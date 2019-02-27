package com.dajiabao.readsource;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by wangc on 2018/8/30
 * E-MAIL:274281610@QQ.COM
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context mContext;
    private List<String> datas;

    public  MyAdapter(Context mContext,List<String> datas){
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
            view   = LayoutInflater.from(mContext).inflate(R.layout.layout_item,parent,false);
        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.textView.setText(datas.get(position));

        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        holder.recyclerView.setAdapter(new MyAdapter1(mContext,this.datas));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private RecyclerView recyclerView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
            recyclerView = itemView.findViewById(R.id.rv);
        }
    }
}
