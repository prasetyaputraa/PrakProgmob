package com.example.fx504.praktikum.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fx504.praktikum.R;
import com.example.fx504.praktikum.api.APIClient;
import com.example.fx504.praktikum.api.APIService;
import com.example.fx504.praktikum.model.ResponseApi;
import com.example.fx504.praktikum.model.SharePref;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {


    APIService apiService;

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

        apiService = APIClient.getService();

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_phone    = findViewById(R.id.et_phone);
        et_email    = findViewById(R.id.et_email);
        btn_submit  = findViewById(R.id.btn_submit);




        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMember();
            }
        });

    }

    public void addMember(){
        final String username     = et_username.getText().toString();
        final String password     = et_password.getText().toString();
        final String phone_number = et_phone.getText().toString();
        final String email        = et_email.getText().toString();

        if (!username.equals("") && !password.equals("")
                && !phone_number.equals("") && !email.equals("")
                && !username.equals("admin") && !password.equals("admin")){

            apiService.CreateMember(username,password,email,phone_number)
                    .enqueue(new Callback<ResponseApi>() {
                        @Override
                        public void onResponse(Call<ResponseApi> call, Response<ResponseApi> response) {
//                            sharePref.setData(username,password,phone_number,email,0);
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<ResponseApi> call, Throwable t) {
                            Toast.makeText(RegisterActivity.this, "Gagal Menyimpan",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        }else {
            Toast.makeText(RegisterActivity.this, "Input Data", Toast.LENGTH_SHORT).show();
        }
    }

}