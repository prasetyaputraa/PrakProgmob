package com.example.fx504.praktikum.model;

import android.widget.TextView;

public class Genre {
    private String GenreType;
    private int Thubnail;

    public Genre(){

    }

    public Genre(String genreType, int thubnail){
        GenreType  = genreType;
        Thubnail = thubnail;
    }


    public String getGenreType() {
        return GenreType;
    }

    public void setGenreType(String genreType) {
        GenreType = genreType;
    }

    public int getThubnail() {
        return Thubnail;
    }

    public void setThubnail(int thubnail) {
        Thubnail = thubnail;
    }
}
