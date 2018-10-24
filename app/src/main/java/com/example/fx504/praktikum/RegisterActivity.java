package com.example.fx504.praktikum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {


    EditText et_username;
    EditText et_password;
    EditText et_email;
    EditText et_phone;

    Button btn_submit;
    SharePref sharePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sharePref = new SharePref(this);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_phone = findViewById(R.id.et_phone);
        et_email    = findViewById(R.id.et_email);
        btn_submit  = findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharePref.setDataString(SharePref.KEY_NAME,  et_username.getText().toString());
                sharePref.setDataString(SharePref.KEY_PASS,  et_password.getText().toString());
                sharePref.setDataString(SharePref.KEY_PHONE,  et_phone.getText().toString());
                sharePref.setDataString(SharePref.KEY_EMAIL, et_email.getText().toString());
                sharePref.setDataInt(SharePref.KEY_VALUE,0);


                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}