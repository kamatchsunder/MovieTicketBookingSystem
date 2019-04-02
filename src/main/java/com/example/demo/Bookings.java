package com.example.demo;

import com.example.demo.Theatre.NormalScreen;
import com.example.demo.Theatre.Screen;
import com.example.demo.Theatre.Theatre;
import com.example.demo.movie.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


public class Bookings implements AdminOperation{

    private static Bookings bookings = new Bookings();
    Map<Integer,Theatre> theatreMap = new ConcurrentHashMap<>();


    private String[] rows = {"A","B","C"};

    private Bookings() {

    }


    public static Bookings getBookings() {

        return bookings;
    }


    public void addTheatre(Theatre theatre) {

        theatreMap.put(theatre.getTheatreId(),theatre);
    }


    public void addMovieToTheatre(Theatre theatre, Movie movie) {

        theatreMap.putIfAbsent(theatre.getTheatreId(), theatre);
        Theatre theatre1;

        theatre1 = theatreMap.get(theatre.getTheatreId());
        Map<Integer, Screen> integerScreenMap = new HashMap<>();
        for (int i = 0; i < theatre1.getNoOfScreens(); i++) {

            Screen screen = new NormalScreen(i, "name" + i, movie, rows, 10);
            integerScreenMap.put(1, screen);
        }

        theatre1.setScreenMap(integerScreenMap);

    }


    public void removeMovieFromTheatre(Theatre theatre, Movie movie) {

        Theatre theatre1 = theatreMap.get(theatre.getTheatreId());
        Map<Integer,Screen> screenMap = theatre1.getScreenMap();

        if( !screenMap.isEmpty()){

            for(Map.Entry<Integer,Screen> entry : screenMap.entrySet()){

                if(entry.getValue().getMovie().equals(movie)){
                    screenMap.remove(entry.getKey());
                }
            }
        }

    }


    public void removeTheatre(Theatre theatre) {

        theatreMap.remove(theatre.getTheatreId());
    }

    public List<Theatre> getListOfTheatresForMovie(String movieName){

        return theatreMap.entrySet()
                .stream().filter(entry -> entry.getValue().getScreenMap().values().stream().anyMatch(screen -> screen.getMovie
                ().getMovieName().equals(movieName)))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

}
