package com.example.fx504.praktikum.model;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePref{

    public final static String SP_NAME    = "sharePref";
    public final static String KEY_NAME   = "user_name";
    public final static String KEY_PASS   = "user_pass";
    public final static String KEY_EMAIL  = "user_email";
    public final static String KEY_PHONE  = "user_phone";
    public final static String KEY_VALUE  = "0";
    private SharedPreferences sharedPreferences;

    public SharePref(Context context) {
        sharedPreferences=context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);

    }

    public void setDataString(String key, String val){
        sharedPreferences.edit().putString(key,val).apply();
    }
    public void setDataInt(String key, int val){
        sharedPreferences.edit().putInt(key,val).apply();
    }

    public String getDataString(String key){
        return sharedPreferences.getString(key,"");
    }
    public int getDataInt(String key, int defValue){
        return sharedPreferences.getInt(key,defValue);
    }

    public void setData(String user_name, String user_pass, String user_email, String user_phone, int val){
        sharedPreferences.edit().putString(KEY_NAME,user_name).apply();
        sharedPreferences.edit().putString(KEY_PASS,user_pass).apply();
        sharedPreferences.edit().putString(KEY_EMAIL,user_email).apply();
        sharedPreferences.edit().putString(KEY_PHONE,user_phone).apply();
        sharedPreferences.edit().putInt(KEY_VALUE,val).apply();

    }
}