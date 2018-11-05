package com.praktikummobile.kelompok7.novelite;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.praktikummobile.kelompok7.novelite.fragment.FragmentFavorites;
import com.praktikummobile.kelompok7.novelite.fragment.FragmentHome;
import com.praktikummobile.kelompok7.novelite.fragment.FragmentProfile;

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
                     fragment = new FragmentHome();
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

}
