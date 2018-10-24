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

    Button btn_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_email    = findViewById(R.id.et_email);
        btn_submit  = findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                SharedPreferences sp = getSharedPreferences(BIO_USER, Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sp.edit();
//
//                editor.putString(KEY_NAME,""+et_username.getText().toString());
//                editor.putString(KEY_PASS,""+et_password.getText().toString());
//                editor.putString(KEY_EMAIL,""+et_email.getText().toString());
//                editor.putInt(KEY_VALUE,0);
//                editor.apply();

                SharePref sharePref = new SharePref();

                sharePref.setDataString(SharePref.KEY_NAME,  et_username.getText().toString());
                sharePref.setDataString(SharePref.KEY_PASS,  et_password.getText().toString());
                sharePref.setDataString(SharePref.KEY_EMAIL, et_email.getText().toString());
                sharePref.setDataInt(SharePref.KEY_VALUE,0);


                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
