package com.example.fx504.praktikum.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fx504.praktikum.R;
import com.example.fx504.praktikum.model.Genre;
import com.example.fx504.praktikum.model.Novel;

import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.MyViewHolder> {
    private Context context;
    private List<Genre> genres;

    public GenreAdapter(Context context, List<Genre> genres){
        this.context = context;
        this.genres  = genres;
    }

    @NonNull
    @Override
    public GenreAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_genre, viewGroup ,false);



        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.iv_genre.setImageResource(genres.get(position).getThubnail());
    }


    @Override
    public int getItemCount() {
        return genres.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_genre;


        public MyViewHolder(View itemView){
            super(itemView);

            iv_genre = itemView.findViewById(R.id.iv_genre);

        }
    }
}
