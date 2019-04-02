package com.example.demo.Theatre;

import com.example.demo.movie.Movie;


public abstract class Screen {

    private int screenId;
    private String screenName;

    private Movie movie;

    private Seat[][] seats;

    private String[] rows;
    private int columns;


    public Movie getMovie() {

        return movie;
    }



    public Screen(int screenId, String screenName, Movie movie,String[] rows,int columns) {

        this.screenId = screenId;
        this.screenName = screenName;
        this.movie = movie;

        this.rows = rows;
        this.columns = columns;
        initSeats();

    }


    private void initSeats() {

        seats = new Seat[rows.length][columns];
        for(int i=0;i<rows.length;i++){

            for(int j=0;j<columns;j++){

                    seats[i][j] = new Seat(rows[i]+j,SeatType.NORMAL,SeatStatus.AVILABLE);

            }
        }

    }


    public boolean isSeatsAvailable(String seatNumber){

        for(int i=0;i<rows.length;i++){

            for(int j=0;j<columns;j++){

                if(seats[i][j] !=null){
                    Seat seat =seats[i][j];
                    if(seat.getSeatNumber().equals(seatNumber) && seat.getSeatStatus()==SeatStatus.AVILABLE){
                        return true;
                    }

                }

            }
        }
        return false;
    }


    public String allocateSeat(String seatNumber){

        for(int i=0;i<rows.length;i++){

            for(int j=0;j<columns;j++){

                if(seats[i][j] !=null){
                    Seat seat =seats[i][j];
                    if(seat.getSeatNumber().equals(seatNumber) && seat.getSeatStatus()==SeatStatus.AVILABLE){
                        seat.setSeatStatus(SeatStatus.BOOKED);
                        return "seat Booked";
                    }

                }

            }
        }

        return "seat Not Booked";

    }


    public void setMovie(Movie movie) {

        this.movie = movie;
    }



}
