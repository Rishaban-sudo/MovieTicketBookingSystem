package com.movieTicketBookingSystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Theatre {
    private String name;
    private Integer noOfScreens;
    private final HashMap<Integer,Screen> screens;
    private final HashMap<String,User> users;


    public Theatre(String name,int noOfScreens) {
        this.name = name;
        this.noOfScreens = noOfScreens;
        screens = new HashMap<>();
        users = new HashMap<>();
        configureScreens();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNoOfScreens() {
        return noOfScreens;
    }

    public void setNoOfScreens(Integer noOfScreens) {
        this.noOfScreens = noOfScreens;
    }

    public void signUp() {
        String name,phoneNumber,emailId,password;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name : ");
        name = sc.nextLine();

        System.out.println("Enter your phone number : ");
        phoneNumber = sc.next();

        System.out.println("Enter your email Id : ");
        emailId = sc.next();

        System.out.println("Set a password : ");
        password = sc.next();

        if(users.containsKey(emailId)) {
            System.out.println("Email id already exists !");
        }
        else {
            users.put(emailId, new User(name, phoneNumber, emailId,password));
            System.out.println("Signed up successfully !");
        }

    }

    public User logIn() {
        String emailId,password;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your emailId : ");
        emailId = sc.next();

        System.out.println("Enter your password : ");
        password = sc.next();

        sc.nextLine();
        if( users.containsKey(emailId) && users.get(emailId).getPassword().equals(password) ) {
            System.out.println("Logged In successfully !! ");
            System.out.println("Welcome Mr/Mrs "+users.get(emailId).getName());
            return users.get(emailId);
        }
        else {
            System.out.println("Email id or password do not match !!");
        }
        return null;
    }

    public void configureScreens() {

        /*System.out.print("Setting up initial configurations Please wait !");
        for (int c=5;c!=1;c--){
            try {
                Thread.sleep(1000);
                System.out.print(".");
            } catch (InterruptedException ignored) {}
        }

        System.out.println();*/

        for(int i=0;i<noOfScreens;i++) {
            String name="";
            int screenNo;

            name= "Screen"+(i+1);
            screenNo=(i+1);

            screens.put(screenNo, new Screen(name, screenNo));
        }

    }

    public void displayShows() {
        Collection<Screen> screen = screens.values();
        for (Screen value : screen) {
            System.out.println(value);
        }
    }


    public Booking book() {
        int screenNo=0;

        System.out.println("~~~~List of Shows~~~~");
        displayShows();

        Scanner sc = new Scanner(System.in);

        System.out.println("Select your Screen no: ");


        screenNo= sc.nextInt();
        if(screenNo>noOfScreens){
            throw new InvalidScreenNoException();
        }


        Screen screen = screens.get(screenNo);
        System.out.println("1.9:00am show ");
        System.out.println("2.12:00pm show ");
        System.out.println("3.6:00pm show ");
        int ch = sc.nextInt();
        Show show=null;
        int tickets=0;

        switch(ch){
            case 1:
                show=screen.getShow("9:00am");
                System.out.println("Enter the number of tickets : ");
                tickets=sc.nextInt();
                if( !show.bookMyShow(tickets) ){
                    return null;
                }
                break;
            case 2:
                show=screen.getShow("12:00pm");
                System.out.println("Enter the number of tickets : ");
                tickets=sc.nextInt();
                if( !show.bookMyShow(tickets) ){
                    return null;
                }
                break;
            case 3:
                show=screen.getShow("6:00pm");
                System.out.println("Enter the number of tickets : ");
                tickets=sc.nextInt();
                if( !show.bookMyShow(tickets) ){
                    return null;
                }
                break;
        }

        return new Booking(show, tickets);
    }

    public void cancel(User user) {

        Scanner sc = new Scanner(System.in);

        if(user.getNoOfBookings()==0) {
            System.out.println("No bookings to cancel !");
            return;
        }

        user.myBookings();

        System.out.println("Enter your booking id which you want to cancel :");
        String bookingId = sc.next();

        Booking booking = user.getBooking(bookingId);
        if(booking!=null){
            booking.cancelBooking();

            user.removeBooking(bookingId);

            System.out.println("Booking cancelled Successfully ! ");
        }
        else{
            System.out.println("Enter a valid booking id");
        }


    }

}
