package com.veken.mvpdemo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author Veken
 * @date on 2018/1/31 10:24
 * @describe
 */

public class ToastUtil {

    public static void toastShort(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }

    public static void toastLong(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_LONG).show();
    }
}
