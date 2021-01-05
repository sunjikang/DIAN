package com.xing.commonbase.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class AppUtil {

    private AppUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 获取版本名称
     */
    public static String getVerName(Context context) {
        String verName = null;
        try {
            verName = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;
    }

    /**
     * 获取版本号
     */
    public static int getVerCode(Context context) {
        int verName = 0;
        try {
            verName = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return verName;
    }

    /**
     * 获取包名
     */
    public static String getPackageName(Context context) {
        String verName = null;
        try {
            verName = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;
    }

    public static String getAppName(Context context) {
        PackageManager pm = context.getPackageManager();
        return context.getApplicationInfo().loadLabel(pm).toString();
    }

}
