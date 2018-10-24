package com.example.fx504.praktikum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Condition extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharePref sharePref = new SharePref();
        int myVal = sharePref.getDataInt(SharePref.KEY_VALUE);

        Intent intent;
        if (myVal==1){
            intent = new Intent(Condition.this, DisplayActivity.class);
            startActivity(intent);
        }else {
            intent = new Intent(Condition.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
