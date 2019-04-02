package com.example.demo.Theatre;

import com.example.demo.IMovieBooking;
import com.example.demo.movie.Movie;
import com.example.demo.user.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Theatre implements IMovieBooking {

    private int theatreId;
    private String theatreName;
    private int noOfScreens;

    private Map<Integer, Screen> screenMap = new ConcurrentHashMap<>();


    public Theatre(int theatreId, String theatreName, int noOfScreens) {

        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.noOfScreens = noOfScreens;
    }


    public int getNoOfScreens() {

        return noOfScreens;
    }


    public void setNoOfScreens(int noOfScreens) {

        this.noOfScreens = noOfScreens;
    }



    public Map<Integer, Screen> getScreenMap() {

        return screenMap;
    }


    public void setScreenMap(Map<Integer, Screen> screenMap) {

        this.screenMap = screenMap;
    }


    public int getTheatreId() {

        return theatreId;
    }


    public void setTheatreId(int theatreId) {

        this.theatreId = theatreId;
    }


    public String getTheatreName() {

        return theatreName;
    }


    public void setTheatreName(String theatreName) {

        this.theatreName = theatreName;
    }


    @Override
    public int hashCode() {

        return theatreId;
    }


    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Theatre) {
            Theatre theatre = (Theatre) obj;

            return theatre.theatreId == this.theatreId;
        }
        return false;
    }


    @Override
    public String bookTickets(Movie movie, List<String> seatNumbers, User user) {

        Map<Integer, Screen> screenMap = this.getScreenMap();

        Screen screen = screenMap.entrySet().stream()
                .filter(integerScreenEntry -> integerScreenEntry.getValue().getMovie().equals(movie))
                .map(Map.Entry::getValue)
                .findAny().get();

        if (seatNumbers.stream()
                .allMatch(screen::isSeatsAvailable)) {

            seatNumbers.forEach(screen::allocateSeat);

            return "tickets Booked";

        }

        return "Tickets not Booked";
    }

}
