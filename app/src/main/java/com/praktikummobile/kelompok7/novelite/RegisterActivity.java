package com.praktikummobile.kelompok7.novelite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        et_phone    = findViewById(R.id.et_phone);
        et_email    = findViewById(R.id.et_email);
        btn_submit  = findViewById(R.id.btn_submit);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username     = et_username.getText().toString();
                final String password     = et_password.getText().toString();
                final String phone_number = et_phone.getText().toString();
                final String email        = et_email.getText().toString();
                if (!username.equals("") && !password.equals("")
                        && !phone_number.equals("") && !email.equals("")){
                    sharePref.setDataString(SharePref.KEY_NAME, ""+ username);
                    sharePref.setDataString(SharePref.KEY_PASS,  ""+password);
                    sharePref.setDataString(SharePref.KEY_PHONE, ""+ phone_number);
                    sharePref.setDataString(SharePref.KEY_EMAIL, ""+email);
                    sharePref.setDataInt(SharePref.KEY_VALUE,1);
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(RegisterActivity.this, "Input Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}