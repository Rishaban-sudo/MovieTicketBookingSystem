package com.movieTicketBookingSystem;

public class Show {
    private String showTime;
    private int maxNoOfTickets;
    private String currentMovie;
    private int ticketsFilled =0;
    private Screen screen;

    public Show(Screen screen,String showTime, int maxNoOfTickets,String currentMovie) {
        this.screen=screen;
        this.showTime = showTime;
        this.maxNoOfTickets = maxNoOfTickets;
        this.currentMovie = currentMovie;
    }


    public String getShowTime() {
        return showTime;
    }

    public boolean bookMyShow(int tickets) {
        if(ticketsFilled+tickets >maxNoOfTickets) {
            System.out.println("Show house full !");
            return false;
        }
        else {
            ticketsFilled +=tickets;
            System.out.println("Booked successfully !");
        }
        return true;
    }

    public void cancelMyShow(int tickets) {
        ticketsFilled-=tickets;
    }

    public String display() {
        return "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+"\n"+
                "Screen no= "+screen.getScreenNo()+"\n"+
                "showTime= " + showTime + "\n" +
                "currentMovie = " + currentMovie + "\n";
    }

    @Override
    public String toString() {
        return  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+"\n"+
                "showTime= " + showTime + "\n" +
                "Available Tickets = " + maxNoOfTickets +"\n"+
                "ticketsFilled = " + ticketsFilled +"\n"+
                "currentMovie = " + currentMovie + "\n";
    }
}
