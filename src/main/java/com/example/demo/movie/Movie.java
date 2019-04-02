package com.example.demo.movie;

public class Movie {

    private int movieId;
    private String movieName;
    private long duration;
    private Language language;
    private String metadata;


    public Movie(int movieId, String movieName, long duration, Language language) {

        this.movieId = movieId;
        this.movieName = movieName;
        this.duration = duration;
        this.language = language;
    }


    public int getMovieId() {

        return movieId;
    }


    public void setMovieId(int movieId) {

        this.movieId = movieId;
    }


    public String getMovieName() {

        return movieName;
    }


    public void setMovieName(String movieName) {

        this.movieName = movieName;
    }


    public long getDuration() {

        return duration;
    }


    public void setDuration(long duration) {

        this.duration = duration;
    }


    public Language getLanguage() {

        return language;
    }


    public void setLanguage(Language language) {

        this.language = language;
    }


    public String getMetadata() {

        return metadata;
    }


    public void setMetadata(String metadata) {

        this.metadata = metadata;
    }
}

