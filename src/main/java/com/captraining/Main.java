package com.captraining;

import com.captraining.entity.Attendee;
import com.captraining.entity.Event;
import com.captraining.entity.Role;
import com.captraining.entity.User;
import com.captraining.exception.InvalidBookingException;
import com.captraining.service.EventBookingSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EventBookingSystem system = new EventBookingSystem();
        system.loadEvents();
        Scanner sc = new Scanner(System.in);
        while(true){
             System.out.println("\n1. Register Attendee\n2. Add Event\n3. Book Ticket\n4. Show Events\n5. Save \n6.Exit");
             System.out.println("Choose Option");
             int choice = sc.nextInt();
             sc.nextLine();
             try{
                switch(choice){
                    case 1 -> {
                        System.out.println("Enter Attendant ID ");
                        String id = sc.nextLine();
                        System.out.print("Enter Attendee Name: ");
                        String aname = sc.nextLine();
                        User user = new Attendee(id, aname);
                        system.registerUser(user, Role.Attendee);
                    }
                    case 2 -> {
                        System.out.print("Enter Event Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Available Tickets: ");
                        int tickets = sc.nextInt();
                        sc.nextLine();
                        system.addEvent(new Event(title, tickets));
                    }
                    case 3 -> {
                        System.out.print("Enter Attendee ID: ");
                        String id = sc.nextLine();
                        Attendee found = null;
                        for (Attendee a : system.getAttendees()) {
                            if (a.getId().equals(id)) {
                                found = a;
                            }
                        }
                        if (found == null) {
                            System.out.println("Attendee not found.");
                            throw new RuntimeException("Id Not Found");
                        }
                        System.out.print("Enter Event Title to Book: ");
                        String etitle = sc.nextLine();
                        Attendee finalFound = found;
                        system.getEvents().stream().filter(e -> e.getTitle().equals(etitle)).findFirst().ifPresentOrElse(event -> {
                            try {
                                if(!event.isAvailable()) {
                                    throw new InvalidBookingException("No tickets available for this event.");
                                }
                                system.bookTicket(finalFound, event);
                                event.setAvailableTickets(event.getAvailabeTickets() - 1);
                                System.out.println("Ticket Booked Successfully");
                            } catch (InvalidBookingException e) {
                                System.out.println("Booking Failed: " + e.getMessage());
                            }
                        }, () -> System.out.println("Event not found."));
                    }
                    case 4 -> {
                        System.out.println("Available Events:");
                        system.showEvents();
                    }
                    case 5 -> {
                        system.saveEvents();
                    }
                    case 6 -> {
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);
                    }
                    default ->{
                        System.out.println("Invalid Option");
                    }
                }

             }catch(InvalidBookingException e){
                System.out.println("Booking Failed: "+ e.getMessage());
             }
        }
    }
}