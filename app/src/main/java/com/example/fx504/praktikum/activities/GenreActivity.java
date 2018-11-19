package com.example.fx504.praktikum.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fx504.praktikum.R;
import com.example.fx504.praktikum.adapter.GenreAdapter;
import com.example.fx504.praktikum.model.Genre;

import java.util.ArrayList;
import java.util.List;

public class GenreActivity extends AppCompatActivity {

    RecyclerView rc_genre;
    List<Genre> genreList;
    GenreAdapter genreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        rc_genre = findViewById(R.id.rc_genre);

        setGenreList();
    }

    public void setGenreList(){


        genreList = new ArrayList<>();

        genreList.add(new Genre("Action"));
        genreList.add(new Genre("Comedy"));
        genreList.add(new Genre("Romane"));
        genreList.add(new Genre("Drama"));
        genreList.add(new Genre("Sport"));
        genreList.add(new Genre("Horror"));
        genreList.add(new Genre("Slice of Life"));
        genreList.add(new Genre("Fantasy"));
        genreList.add(new Genre("Sci Fi"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        genreAdapter = new GenreAdapter(this, genreList);
        rc_genre.setLayoutManager(layoutManager);
        rc_genre.setAdapter(genreAdapter);

    }
}
