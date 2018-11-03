package com.example.fx504.praktikum.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.fx504.praktikum.activitys.FullScreenActivity;
import com.example.fx504.praktikum.activitys.MainActivity;

public class Condition extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharePref sharePref = new SharePref(this);
        int myVal = sharePref.getDataInt(SharePref.KEY_VALUE, 0);
        Log.d("InputVal","Value Condition :"+myVal);
        Intent intent;
        if (myVal==1){

            intent = new Intent(Condition.this, MainActivity.class);
            startActivity(intent);

        }else {
            intent = new Intent(Condition.this, FullScreenActivity.class);
            startActivity(intent);
        }
        finish();
    }
}
