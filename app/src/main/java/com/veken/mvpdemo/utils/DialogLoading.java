package com.veken.mvpdemo.utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.veken.mvpdemo.R;

/**
 * @author Veken
 * @date on 2018/2/1 10:38
 * @describe
 */


public class DialogLoading {

    public static Dialog getLoadingDialog(Context context) {
        ProgressDialog pd = null;
        if (pd == null) {
            pd = new ProgressDialog(context);
            pd.setMessage("正在拼命加载中……");
        }
        if (!pd.isShowing()) {
            pd.show();
        }
        return pd;
    }
}
