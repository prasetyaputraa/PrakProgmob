package com.example.fx504.praktikum.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fx504.praktikum.R;
import com.example.fx504.praktikum.adapter.GenreAdapter;
import com.example.fx504.praktikum.adapter.NovelViewAdapter;
import com.example.fx504.praktikum.model.Genre;
import com.example.fx504.praktikum.model.Novel;

import java.util.ArrayList;
import java.util.List;

public class FragHome extends Fragment {

    List<Novel> myNovel;
    List<Genre> myGenre;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home,container,false);

        // Favorite Novel
        setFav(view);

        // Genre Novel
        setMyGenre(view);

        // Update Novel
        setNovelUpdate(view);


        return view;
    }


    public void setFav(View v){
        RecyclerView recyclerView;
        NovelViewAdapter novelAdapter;

        myNovel = new ArrayList<>();

        for (int i =0; i<3; i++){
            myNovel.add(new Novel("Search Love", "Romance", "About someone who always find another to fix hem",R.drawable.n_searchlove));
            myNovel.add(new Novel("Aullido", "Horror", "Description this Novel",R.drawable.n_aullido));
        }
        recyclerView = v.findViewById(R.id.rc_fav);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        novelAdapter = new NovelViewAdapter(getContext(), myNovel);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(novelAdapter);
    }

    public void setMyGenre(View v){
        RecyclerView recyclerView;
        GenreAdapter genreAdapter;

        myGenre = new ArrayList<>();

        myGenre.add(new Genre("Action", R.drawable.gr_action));
        myGenre.add(new Genre("Comedy", R.drawable.gr_comedy));
        myGenre.add(new Genre("Fantasy", R.drawable.gr_fantas));
        myGenre.add(new Genre("History", R.drawable.gr_history));
        myGenre.add(new Genre("Horror", R.drawable.gr_horror));
        myGenre.add(new Genre("Romance", R.drawable.gr_romace));
        myGenre.add(new Genre("Sci fi", R.drawable.gr_scifi));
        myGenre.add(new Genre("Sport", R.drawable.gr_sport));

        recyclerView = v.findViewById(R.id.rc_genre);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        genreAdapter = new GenreAdapter(getContext(),myGenre);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(genreAdapter);

    }

    public void setNovelUpdate(View v){
        RecyclerView recyclerView;
        NovelViewAdapter novelAdapter;

        myNovel = new ArrayList<>();

        for (int i =0; i<6; i++){
            myNovel.add(new Novel("Search Love", "Romance", "About someone who always find another to fix hem",R.drawable.n_searchlove));
            myNovel.add(new Novel("Aullido", "Horror", "Description this Novel",R.drawable.n_aullido));
        }
        recyclerView = v.findViewById(R.id.rc_novelRilis);


        novelAdapter = new NovelViewAdapter(getContext(), myNovel);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(novelAdapter);
    }

}
