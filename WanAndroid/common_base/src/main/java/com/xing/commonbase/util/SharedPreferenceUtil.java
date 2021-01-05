package com.xing.commonbase.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.xing.commonbase.base.BaseApplication;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SharedPreferenceUtil {

    private SharedPreferenceUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void write(String name, String key, Object value) {
        SharedPreferences sp = BaseApplication.getApplication().getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Set) {
            editor.putStringSet(key, (Set<String>) value);
        }
        editor.apply();
    }

    public static String read(String name, String key, String defValue) {
        SharedPreferences sp = BaseApplication.getApplication().getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static int read(String name, String key, int defValue) {
        SharedPreferences sp = BaseApplication.getApplication().getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    public static boolean read(String name, String key, boolean defValue) {
        SharedPreferences sp = BaseApplication.getApplication().getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static HashSet read(String name, String key, HashSet defValue) {
        SharedPreferences sp = BaseApplication.getApplication().getSharedPreferences(name, Context.MODE_PRIVATE);
        return (HashSet) sp.getStringSet(key, defValue);
    }

}
