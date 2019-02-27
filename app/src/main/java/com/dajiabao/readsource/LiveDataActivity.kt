package com.dajiabao.readsource

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView
import android.widget.ListView

class LiveDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        //        MyViewModle  viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        val listView = findViewById<ListView>(R.id.lv)
        listView.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScrollStateChanged(view: AbsListView, scrollState: Int) {

            }

            override fun onScroll(view: AbsListView, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {

            }
        })
    }


    inner class MyViewModle : ViewModel() {

        fun getData() {

        }

    }
}
