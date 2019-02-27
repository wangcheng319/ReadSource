package com.dajiabao.readsource;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.paging.DataSource;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.arch.paging.PagedListAdapter;
import android.arch.paging.PositionalDataSource;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CheckableImageButton;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import butterknife.BindView;

public class BottomSheetActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        recyclerView = findViewById(R.id.rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayout.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);


        final MyAdapter mAdapter = new MyAdapter();
        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(10)                         //配置分页加载的数量
                .setEnablePlaceholders(false)     //配置是否启动PlaceHolders
                .setInitialLoadSizeHint(10)              //初始化加载的数量
                .build();
        LiveData<PagedList<DataBean>> liveData = new LivePagedListBuilder(new MyDataSourceFactory(), config)
                .build();
        liveData.observe(this,new Observer<PagedList<DataBean>>() {
            @Override
            public void onChanged(@Nullable PagedList<DataBean> dataBeans) {
                if (null==dataBeans || dataBeans.size() == 0){
                    Log.e("+++","no data!!!");
                }else {
                    mAdapter.submitList(dataBeans);
                }

            }
        });

        mAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(mAdapter);
    }


    private class DataBean {
        public int id;
        public String content;
    }

    private class MyDataSourceFactory extends DataSource.Factory<Integer,DataBean>{
        @Override
        public DataSource<Integer, DataBean> create() {
            return new MyDataSource();
        }
    }

    private class MyDataSource extends PositionalDataSource<DataBean> {

        @Override
        public void loadInitial(@NonNull LoadInitialParams params,@NonNull LoadInitialCallback<DataBean> callback) {
            callback.onResult(loadData(0, 10),0,10);
        }

        @Override
        public void loadRange(@NonNull LoadRangeParams params
                ,@NonNull LoadRangeCallback<DataBean> callback) {
            callback.onResult(loadData(params.startPosition, 10));

        }

    }

    /**
     * 假设这里需要做一些后台线程的数据加载任务。
     *
     * @param startPosition
     * @param count
     * @return
     */
    private List<DataBean> loadData(int startPosition,int count) {

        List<DataBean> list = new ArrayList();

        for (int i = 0; i < count; i++) {
            DataBean data = new DataBean();
            data.id = startPosition + i;
            data.content = "测试的内容=" + data.id;
            list.add(data);
        }

        return list;
    }


    private class MyAdapter extends PagedListAdapter<DataBean, MyViewHolder> {
        public MyAdapter() {
            super(mDiffCallback);
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(android.R.layout.simple_list_item_2,null);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder,int position) {
            DataBean data = getItem(position);
            holder.text1.setText(String.valueOf(position));
            holder.text2.setText(String.valueOf(data.content));
        }
    }

    private DiffUtil.ItemCallback<DataBean> mDiffCallback = new DiffUtil.ItemCallback<DataBean>() {
        @Override
        public boolean areItemsTheSame(@NonNull DataBean oldItem,@NonNull DataBean newItem) {
            Log.d("DiffCallback","areItemsTheSame");
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull DataBean oldItem,@NonNull DataBean newItem) {
            Log.d("DiffCallback","areContentsTheSame");
            return (oldItem == newItem);
        }
    };

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text1;
        public TextView text2;

        public MyViewHolder(View itemView) {
            super(itemView);

            text1 = itemView.findViewById(android.R.id.text1);
            text1.setTextColor(Color.RED);

            text2 = itemView.findViewById(android.R.id.text2);
            text2.setTextColor(Color.BLUE);
        }
    }

    class mySnapHelper extends SnapHelper{

        @Nullable
        @Override
        public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View targetView) {
            return new int[0];
        }

        @Nullable
        @Override
        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            return null;
        }

        @Override
        public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
            return 0;
        }
    }

}
