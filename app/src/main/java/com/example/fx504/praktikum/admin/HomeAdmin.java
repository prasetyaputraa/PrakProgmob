package com.example.fx504.praktikum.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.fx504.praktikum.R;

public class HomeAdmin extends AppCompatActivity {

    CardView cv_addNovel;
    CardView cv_editNovel;
    CardView cv_deleteNovel;
    CardView cv_profileAdmin;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);


        setCv_addNovel();


    }


    public void setCv_addNovel() {
        cv_addNovel = findViewById(R.id.cv_addNovel);
        cv_addNovel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(HomeAdmin.this, AddNovel.class);
                startActivity(intent);
            }
        });
    }
}
