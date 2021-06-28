package com;

import com.movieTicketBookingSystem.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Theatre inox = new Theatre("Inox",5);

        Scanner sc = new Scanner(System.in);

	    System.out.println("------------------INOX  ~LIVE THE MOVIE-------------------");
	    while(true) {
            System.out.println("--------------------------------------------");
            System.out.println("Enter your choice");
            System.out.println("1.Sign up ");
            System.out.println("2.Login in ");
            System.out.println("3.Exit");

            int ch;

            try {
                ch= sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter a number to confirm your choice !");
                sc.nextLine();
                continue;
            }

            switch (ch) {
                case 1:
                    inox.signUp();
                    break;
                case 2:
                    User user = inox.logIn();
                    if(user!=null) {
                        int flag=0;
                        while(flag!=1){
                            System.out.println("----------------------------------------");
                            System.out.println("1.Book tickets for movie !");
                            System.out.println("2.Cancel booking !");
                            System.out.println("3.View my show bookings");
                            System.out.println("4.Log out of your Account");
                            System.out.print("Enter your choice : ");

                            try{
                                ch= sc.nextInt();
                            }
                            catch (InputMismatchException e){
                                System.out.println("Please enter a number to confirm your choice !");
                                sc.nextLine();
                                continue;
                            }

                            switch (ch) {
                                case 1:
                                    Booking booking=inox.book();
                                    if(booking!=null){
                                        user.addBooking(booking);
                                    }
                                    break;
                                case 2:
                                    inox.cancel(user);
                                    break;
                                case 3:
                                    user.myBookings();
                                    break;
                                default:
                                    flag++;
                                    break;
                            }
                        }
                    }

                    break;
                default:
                    sc.close();
                    System.exit(0);
            }

        }
    }
}
