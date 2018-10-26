package com.example.fx504.praktikum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    Button btn_login;
    Button btn_register;
    SharePref sharePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         sharePref = new SharePref(this);

        et_username  = findViewById(R.id.et_username);
        et_password  = findViewById(R.id.et_password);

        btn_login    = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        setBtn_login();
        setBtn_register();

    }

    public void setBtn_login() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama     = sharePref.getDataString(SharePref.KEY_NAME);
                String password = sharePref.getDataString(SharePref.KEY_PASS);
                if (et_username.getText().toString().equals(nama) &&
                        et_password.getText().toString().equals(password)){
                    sharePref.setDataInt(SharePref.KEY_VALUE,1);
                    Log.d("InputVal","Value Login"+sharePref.getDataInt(SharePref.KEY_VALUE,0));
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Input Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setBtn_register(){
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


}
