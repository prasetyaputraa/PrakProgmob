package com.example.fx504.praktikum.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fx504.praktikum.R;
import com.example.fx504.praktikum.api.APIClient;
import com.example.fx504.praktikum.api.APIService;
import com.example.fx504.praktikum.model.ResLogin;
import com.example.fx504.praktikum.model.SharePref;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    APIService apiService;

    EditText et_username;
    EditText et_password;
    Button btn_login;
    SharePref sharePref;

    TextView tv_signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         sharePref = new SharePref(this);


        apiService = APIClient.getService();

        et_username  = findViewById(R.id.et_username);
        et_password  = findViewById(R.id.et_password);

        btn_login    = findViewById(R.id.btn_login);
        tv_signUp    = findViewById(R.id.tv_signUp);

        setBtn_login();
        setTv_signUp();

    }

    public void setBtn_login() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callAPI();

//                String name     = sharePref.getDataString(SharePref.KEY_NAME);
//                String password = sharePref.getDataString(SharePref.KEY_PASS);


            }
        });
    }


    private void callAPI(){
        String user = et_username.getText().toString();
        String pass = et_password.getText().toString();

        apiService.LoginUser(user,pass).enqueue(new Callback<ResLogin>() {
            @Override
            public void onResponse(Call<ResLogin> call, Response<ResLogin> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    sharePref.setDataString(SharePref.KEY_TOKEN,""+response.body().getToken());
                    Toast.makeText(LoginActivity.this, ""+response.body().getUserName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Gagal Login", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Gagal Error", Toast.LENGTH_SHORT).show();
            }
        });
    }







    public void setTv_signUp(){
        tv_signUp.setOnClickListener(new View.OnClickListener() {
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
