package com.movieTicketBookingSystem;


import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String name;
    private Integer screenNo;
    private ArrayList<Show> shows;


    public Screen(String name,int screenNo){
        this.name = name;
        this.screenNo=screenNo;
        shows = new ArrayList<>(
                List.of(  new Show(this,"9:00am",50,"Avengers End game"),
                             new Show(this,"12:00pm",50,"Fast and Furious"),
                            new Show(this,"6:00pm",50,"Pirates of caribbean") )
                                );
    }

    public Integer getScreenNo() {
        return screenNo;
    }

    public String getShows() {
        StringBuilder str= new StringBuilder();
        for (Show show : shows) {
            str.append(show.toString());
            str.append("\n");
        }
        return str.toString();
    }

    public Show getShow(String showTime) {
        for(Show show:shows){
            if(show.getShowTime().equals(showTime)){
                return show;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null && getClass() != o.getClass()) return false;
        Screen screen = (Screen) o;
        return screenNo.equals(screen.screenNo);
    }

    @Override
    public int hashCode() {
        return screenNo.hashCode();
    }

    @Override
    public String toString() {
        return "Screen name = " + name + "\n" +
                "screenNo = " + screenNo+"\n"+
                "Show Timings :- "+"\n"+
                getShows();
    }
}
