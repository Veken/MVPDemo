package com.veken.mvpdemo.utils;
import android.widget.Toast;

import com.veken.mvpdemo.ui.base.BaseApplication;

/**
 * @author Veken
 * @date on 2018/1/31 10:24
 * @describe  toast提示
 */

public class ToastUtil {

    public static void toastShort(String text){
        Toast.makeText(BaseApplication.getInstance(),text,Toast.LENGTH_SHORT).show();
    }

    public static void toastLong(String text){
        Toast.makeText(BaseApplication.getInstance(),text,Toast.LENGTH_LONG).show();
    }
}
