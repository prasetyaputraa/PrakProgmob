package com.example.fx504.praktikum;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String BIO_USER   = "shared_preferences";
    final String KEY_NAME   = "user_name";
    final String KEY_PASS   = "user_pass";
    final String KEY_VALUE  = "0";


    EditText et_username;
    EditText et_password;
    Button btn_login;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                SharedPreferences sp = getSharedPreferences(BIO_USER,MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                String nama     = sp.getString(KEY_NAME,"");
                String password = sp.getString(KEY_PASS,"");
                if (et_username.getText().toString().equals(nama) &&
                        et_password.getText().toString().equals(password)){
                    editor.putInt(KEY_VALUE,1);
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Input Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setBtn_register(){
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


}
