package com.example.fx504.praktikum.model;

public class Genre {

    private String GenreType;

    public Genre(){

    }

    public Genre(String genreType) {
        GenreType = genreType;
    }

    public String getGenreType() {
        return GenreType;
    }

    public void setGenreType(String genreType) {
        GenreType = genreType;
    }
}
