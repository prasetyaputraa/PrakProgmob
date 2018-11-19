package com.example.fx504.praktikum.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fx504.praktikum.R;
import com.example.fx504.praktikum.model.Genre;

import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.MyViewHolder>{

    private Context context;
    private List<Genre> genreList;

    public GenreAdapter(Context context, List<Genre> genreList) {
        this.context = context;
        this.genreList = genreList;
    }


    @NonNull
    @Override
    public GenreAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        final LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_genre, viewGroup ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreAdapter.MyViewHolder myViewHolder, int position) {
        myViewHolder.tv_genreTitle.setText(genreList.get(position).getGenreType());
    }

    @Override
    public int getItemCount() {
        return genreList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_genreTitle;

        public MyViewHolder(View itemView){
            super(itemView);

            tv_genreTitle = itemView.findViewById(R.id.tv_genreTitle);

        }
    }
}
