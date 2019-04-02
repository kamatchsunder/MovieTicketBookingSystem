package com.example.demo.Theatre;

import com.example.demo.user.User;


public class Seat {

    private String seatNumber;
    private SeatType seatType;
    private SeatStatus seatStatus;
    private int ticketAmount;


    public User getUser() {

        return user;
    }


    public void setUser(User user) {

        this.user = user;
    }


    private User user;


    public Seat(String seatNumber, SeatType seatType, SeatStatus seatStatus) {

        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }


    public void setTicketAmount(int ticketAmount) {

        if(seatType==SeatType.LUXURY){
            this.ticketAmount = ticketAmount + 50;
        }
        else {
            this.ticketAmount = ticketAmount;
        }
    }


    public String getSeatNumber() {

        return seatNumber;
    }


    public void setSeatNumber(String seatNumber) {

        this.seatNumber = seatNumber;
    }


    public SeatType getSeatType() {

        return seatType;
    }


    public void setSeatType(SeatType seatType) {

        this.seatType = seatType;
    }


    public SeatStatus getSeatStatus() {

        return seatStatus;
    }


    public void setSeatStatus(SeatStatus seatStatus) {

        this.seatStatus = seatStatus;
    }


    public int getTicketAmount() {

        return ticketAmount;
    }
}
