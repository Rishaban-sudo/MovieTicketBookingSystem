package com.movieTicketBookingSystem;

import java.util.ArrayList;
import java.util.Objects;

public class User {

    private String name;
    private String phoneNumber;
    private String emailId;
    private String password;
    private ArrayList<Show> myShows;


    public User(String name,String phoneNumber,String emailId,String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.password = password;
        this.myShows = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void addShow(Show show) {
        myShows.add(show);
    }

    public void myShows() {
        if(myShows.size()==0){
            System.out.println("No bookings !");
        }
        for(Show show:myShows){
            System.out.println(show.display());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null && getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(emailId, user.emailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailId);
    }

    @Override
    public String toString() {
        return  "--------------------------------------"+"\n"+
                "UserName= " + name + "\n" +
                "PhoneNumber= " + phoneNumber + "\n" +
                "EmailId= " + emailId + "\n";
    }

}
