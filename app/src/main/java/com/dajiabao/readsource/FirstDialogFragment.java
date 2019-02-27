package com.dajiabao.readsource;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangc on 2018/8/15
 * E-MAIL:274281610@QQ.COM
 */
public class FirstDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //为了样式统一和兼容性，可以使用 V7 包下的 AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // 设置主题的构造方法
        // AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomDialog);
        builder.setTitle("注意：")
                .setMessage("是否退出应用？")
                .setPositiveButton("确定", null)
                .setNegativeButton("取消", null)
                .setCancelable(false);
        //builder.show(); // 不能在这里使用 show() 方法
        return builder.create();
    }
}
