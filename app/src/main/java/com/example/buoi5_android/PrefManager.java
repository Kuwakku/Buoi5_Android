package com.example.buoi5_android;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    public static final String SHEF_NAME = "Buoi5_Android";

    public static void saveString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHEF_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply(); // 1 luong
    }

    public static String getString(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHEF_NAME, context.MODE_PRIVATE);
        return sharedPreferences.getString(key, null);
    }

    public static void removeString(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHEF_NAME, context.MODE_PRIVATE);
        sharedPreferences.edit().remove(key).apply();
    }
}
