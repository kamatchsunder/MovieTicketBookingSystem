package com.example.demo;

import com.example.demo.Theatre.Theatre;
import com.example.demo.movie.Language;
import com.example.demo.movie.Movie;
import com.example.demo.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        User user = new User();

        user.setUserId(1);
        user.setName("bob");
        user.setEmail("bob@gmail.com");


        Bookings bookings = Bookings.getBookings();

        Theatre theatre = new Theatre(1,"luxe",1);

        Movie movie = new Movie(1,"SD",175,Language.ENGLISH);


        bookings.addMovieToTheatre(theatre,movie);

        List<Theatre> theatres = bookings.getListOfTheatresForMovie("SD");

        Theatre selectedTheatre = theatres.stream()
                .filter(theatre1 -> theatre1.getTheatreId() == theatre.getTheatreId())
                .findAny().get();

        System.out.println(selectedTheatre.bookTickets(movie,Collections.singletonList("A1"),user));

    }

}
