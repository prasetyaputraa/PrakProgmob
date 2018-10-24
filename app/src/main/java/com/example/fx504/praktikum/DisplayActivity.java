package com.example.fx504.praktikum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {


    TextView tv_nama;
    TextView tv_email;
    Button   btn_logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tv_nama    = findViewById(R.id.tv_nama);
        tv_email   = findViewById(R.id.tv_email);
        btn_logout = findViewById(R.id.btn_logout);

        final SharePref sharePref = new SharePref();

        String nama     = sharePref.getDataString(SharePref.KEY_NAME);
        String email    = sharePref.getDataString(SharePref.KEY_EMAIL);

        tv_nama.setText(""+nama);
        tv_email.setText(""+email);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharePref.setDataInt(SharePref.KEY_VALUE,0);
                Intent intent = new Intent(DisplayActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
