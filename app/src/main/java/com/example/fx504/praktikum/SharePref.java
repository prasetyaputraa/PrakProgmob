package com.example.fx504.praktikum;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class SharePref extends Activity {

    final static String SP_NAME    = "sharePref";
    final static String KEY_NAME   = "user_name";
    final static String KEY_PASS   = "user_pass";
    final static String KEY_EMAIL  = "user_email";
    final static String KEY_VALUE  = "0";

    SharedPreferences sp = getSharedPreferences(SP_NAME,MODE_PRIVATE);

    public void setDataString(String key, String val){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, ""+val);
        editor.apply();
    }
    public void setDataInt(String key, int val){
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, val);
        editor.apply();
    }

    public String getDataString(String key){
        return sp.getString(key, "");
    }
    public int getDataInt(String key){
        return sp.getInt(key,0);
    }
}
