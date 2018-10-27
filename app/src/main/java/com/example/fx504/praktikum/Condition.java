package com.example.fx504.praktikum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

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
    }
}
