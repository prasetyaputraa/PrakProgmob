package com.example.fx504.praktikum.activities;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.fx504.praktikum.R;
import com.example.fx504.praktikum.fragment.FragmentHome;
import com.example.fx504.praktikum.fragment.FragmentFavorites;
import com.example.fx504.praktikum.fragment.FragmentProfile;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btn_navView;
    Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_navView = findViewById(R.id.btn_navView);
        btn_navView.setOnNavigationItemSelectedListener(navListener);
        fragment = new FragmentHome();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_layout, fragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                     fragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            fragment = new FragmentHome();
                            break;
                        case R.id.nav_fav:
                            fragment = new FragmentFavorites();
                            break;
                        case R.id.nav_profile:
                            fragment = new FragmentProfile();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_layout, fragment).commit();
                    return true;
                }
            };

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                        finishAffinity();
                        System.exit(0);
                    }
                }).create().show();
    }

}
