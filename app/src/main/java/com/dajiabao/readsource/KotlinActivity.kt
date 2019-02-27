package com.dajiabao.readsource

import android.content.Intent
import android.graphics.Camera
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.CameraManager
import android.nfc.NfcAdapter
import android.nfc.NfcManager
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_kotlin.*
import java.util.*

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        btn.setOnClickListener {te(99) }

        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,Arrays.asList(1,2,3,4))
        lv.adapter = adapter

        lv.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ -> startActivity(Intent(this,Main2Activity::class.java))}

        lv.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY -> te(scrollX) }

        var listener =  MyListener()
        lv.setOnScrollListener(listener)



        Log.e("+++",test1())
    }

    private fun te(position: Int):String{
        var result = "hello kotlin$position"
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show()
        return result
    }

    class MyListener : AbsListView.OnScrollListener{

        override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {

        }

        override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {

        }

    }

    private fun test1():String{
        var i = 10
        when(i){
            in 1..10-> return "10"

        }

        return "1"
    }

    class  MyCallBack : CameraDevice.StateCallback() {
        override fun onOpened(camera: CameraDevice?) {
        }

        override fun onDisconnected(camera: CameraDevice?) {
        }

        override fun onError(camera: CameraDevice?, error: Int) {
        }

    }


}
