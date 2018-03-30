package com.veken.baselibary.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * @author Veken
 * @date on 2018/3/30 14:50
 * @describe
 */

public class UiUtils {
    /**
     * 判断当前应用是否是debug状态
     * @param context
     * @return
     */
    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }
}
