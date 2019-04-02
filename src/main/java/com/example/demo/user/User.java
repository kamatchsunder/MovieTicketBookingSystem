package com.example.demo.user;

public class User {

    private int userId;
    private String name;
    private String email;
    private int phoneNumber;
    private Address address;


    public int getUserId() {

        return userId;
    }


    public void setUserId(int userId) {

        this.userId = userId;
    }


    public String getName() {

        return name;
    }


    public void setName(String name) {

        this.name = name;
    }


    public String getEmail() {

        return email;
    }


    public void setEmail(String email) {

        this.email = email;
    }


    public int getPhoneNumber() {

        return phoneNumber;
    }


    public void setPhoneNumber(int phoneNumber) {

        this.phoneNumber = phoneNumber;
    }


    public Address getAddress() {

        return address;
    }


    public void setAddress(Address address) {

        this.address = address;
    }
}
