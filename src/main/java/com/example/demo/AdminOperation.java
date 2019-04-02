package com.example.demo;

import com.example.demo.Theatre.Theatre;
import com.example.demo.movie.Movie;


public interface AdminOperation {

    void addTheatre(Theatre theatre);

    void addMovieToTheatre(Theatre theatre, Movie movie);

    void removeMovieFromTheatre(Theatre theatre, Movie movie);

    void removeTheatre(Theatre theatre);
}
