package com.dajiabao.readsource;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wangc on 2018/8/30
 * E-MAIL:274281610@QQ.COM
 */
public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder> {

    private Context mContext;
    private List<String> datas;

    public MyAdapter1(Context mContext, List<String> datas){
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public MyAdapter1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
            view   = LayoutInflater.from(mContext).inflate(R.layout.layout_item,parent,false);
        return new MyAdapter1.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter1.ViewHolder holder, int position) {
        holder.textView.setText(datas.get(position));
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
