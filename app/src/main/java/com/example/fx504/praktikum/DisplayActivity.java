package com.example.fx504.praktikum;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    final String BIO_USER   = "shared_preferences";
    final String KEY_NAME   = "user_name";
    final String KEY_EMAIL  = "user_email";
    final String KEY_VALUE  = "0";

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

        SharedPreferences sp = getSharedPreferences(BIO_USER,MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();

        String nama     = sp.getString(KEY_NAME,"");
        String email    = sp.getString(KEY_EMAIL,"");

        tv_nama.setText(""+nama);
        tv_email.setText(""+email);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt(KEY_VALUE,0);
                editor.apply();
                Intent intent = new Intent(DisplayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
