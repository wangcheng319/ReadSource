package com.dajiabao.readsource;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_test);
        findViewById(R.id.btn_input).setOnClickListener((view)->input());
        findViewById(R.id.btn_out).setOnClickListener((View)->out());
    }

    /**
     *写入
     */
    private void input() {
        File file = new File(Environment.getExternalStorageDirectory(),"/text.txt");
        String test = "hello";
        try {
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(test.getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *读取
     */
    private void out() {


    }




}
