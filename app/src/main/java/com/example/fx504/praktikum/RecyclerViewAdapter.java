package com.example.fx504.praktikum;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Novel> novelList;

    public RecyclerViewAdapter(Context context, List<Novel> myNovel) {
        this.context = context;
        this.novelList = myNovel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_novel, viewGroup ,false);



        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.iv_novel_img.setImageResource(novelList.get(position).getThubnail());
        myViewHolder.tv_novel_title.setText(novelList.get(position).getTitle());
        myViewHolder.tv_novel_genre.setText(novelList.get(position).getGenre());

    }

    @Override
    public int getItemCount() {
        return novelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_novel_img;
        TextView tv_novel_title;
        TextView tv_novel_genre;

        public MyViewHolder(View itemView){
            super(itemView);

            iv_novel_img = itemView.findViewById(R.id.iv_novel_img);
            tv_novel_title = itemView.findViewById(R.id.tv_novel_title);
            tv_novel_genre = itemView.findViewById(R.id.tv_novel_genre);




        }
    }
}
