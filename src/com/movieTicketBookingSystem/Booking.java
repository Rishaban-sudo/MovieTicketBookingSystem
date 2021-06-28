package com.movieTicketBookingSystem;


public class Booking {

    private static int idCount=0;

    private final String bookingId;
    private Show myShow;
    private int noOfTickets;

    Booking(Show myShow,int noOfTickets) {
        this.myShow=myShow;
        this.noOfTickets=noOfTickets;
        this.bookingId="I"+(++idCount);
    }

    public String getBookingId() {
        return bookingId;
    }

    public void cancelBooking() {
        myShow.cancelMyShow(noOfTickets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null && getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;

        return bookingId.equals(booking.bookingId);
    }

    @Override
    public int hashCode() {
        return bookingId.hashCode();
    }

    @Override
    public String toString() {
        return myShow.display()+
                "No of tickets : "+noOfTickets+"\n"+
                "Booking Id : " + bookingId+"\n";
    }
}
