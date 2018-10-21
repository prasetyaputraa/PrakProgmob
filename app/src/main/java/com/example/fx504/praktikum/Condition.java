package com.example.fx504.praktikum;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class Condition extends Activity implements Conditions {
    final String BIO_USER   = "shared_preferences";
    final String KEY_VALUE  = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = getSharedPreferences(BIO_USER,MODE_PRIVATE);
        int myVal = sp.getInt(KEY_VALUE,0);

        Intent intent;
        if (myVal==1){
            intent = new Intent(Condition.this, DisplayActivity.class);
            startActivity(intent);
        }else {
            intent = new Intent(Condition.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
