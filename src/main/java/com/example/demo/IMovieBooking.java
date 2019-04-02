package com.example.demo;

import com.example.demo.movie.Movie;
import com.example.demo.user.User;

import java.util.List;


public interface IMovieBooking {

    String bookTickets(Movie movie,List<String> seatNumbers,User user);
}
