package com.example.demo.admin;

import com.example.demo.Bookings;
import com.example.demo.movie.Movie;
import com.example.demo.Theatre.Theatre;


public class Admin {

    private int adminId;

    public void addTheatre(Theatre theatre){

         Bookings bookings = Bookings.getBookings();

         bookings.addTheatre(theatre);
    }

    public void removeTheatre(Theatre theatre){

        Bookings bookings = Bookings.getBookings();

        bookings.removeTheatre(theatre);
    }


    public void addMovie(Theatre theatre,Movie movie){

        Bookings bookings = Bookings.getBookings();

        bookings.addMovieToTheatre(theatre,movie);
    }

}
