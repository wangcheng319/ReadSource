package com.dajiabao.readsource;

/**
 * Created by wangc on 2018/8/30
 * E-MAIL:274281610@QQ.COM
 */
public interface ItemTouchHelperAdapter {

    //数据交换
    void onItemMove(int fromPosition,int toPosition);
    //数据删除
    void onItemDissmiss(int position);
}
