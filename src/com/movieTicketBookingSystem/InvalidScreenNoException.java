package com.movieTicketBookingSystem;

public class InvalidScreenNoException extends RuntimeException{

    @Override
    public String toString() {
        return "Enter a valid screen number ! ";
    }
}
