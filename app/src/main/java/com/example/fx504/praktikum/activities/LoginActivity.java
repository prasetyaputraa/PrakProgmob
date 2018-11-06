package com.example.fx504.praktikum.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fx504.praktikum.R;
import com.example.fx504.praktikum.model.SharePref;

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

                String user = et_username.getText().toString();
                String pass = et_password.getText().toString();
                String name     = sharePref.getDataString(SharePref.KEY_NAME);
                String password = sharePref.getDataString(SharePref.KEY_PASS);

                if (name.equals(user) && password.equals(pass)){
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

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        LoginActivity.super.onBackPressed();
                        finishAffinity();
                        System.exit(0);
                    }
                }).create().show();
    }


}
