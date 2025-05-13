package com.captraining;

import com.captraining.dao.Admin;
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
             System.out.println("\n1. Register Attendee\n2. Add Event\n3. Book Ticket\n4. Show Events\n5. Remove Event (Admin)\n6. Save & Exit");
             System.out.println("Choose Option");
             int choice = sc.nextInt();
             sc.nextLine();
             try{
                switch(choice){
                    case 1:
                    System.out.println("Enter Attendant ID ");
                    System.out.print("Enter Attendee Name: ");
                    String aname = sc.nextLine();
                    User user = new Attendee(aname, aname);
                    system.registerUser(user, Role.Attendee);
                    break;
                    case 2:
                        System.out.print("Enter Event Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Available Tickets: ");
                        int tickets = sc.nextInt();
                        sc.nextLine();
                        system.saveEvents(new Event(title, tickets));
                        break;
                    case 3:
                        System.out.print("Enter Attendee ID: ");
                        String id = sc.nextLine();
                        Attendee found = null;
                        for (Attendee a : system.getAttendees()) {
                            if (a.getId().equals(id)) {
                                found = a;
                                break;
                            }
                        }
                        if (found == null) {
                            System.out.println("Attendee not found.");
                            throw new RuntimeException("Id Not Found");
                        }
                        System.out.print("Enter Event Title to Book: ");
                        String etitle = sc.nextLine();
                        system.bookTicket();
                        break;    
                    case 4:
                    system.showEvents();
                    break;
                 
                    case 5:
                    system.saveEvents();
                    System.out.println("Events Saved");
                    return;
                    default:
                    System.out.println("Invalid Option");




                }

             }catch(InvalidBookingException e){
                System.out.println("Booking Failed: "+ e.getMessage());
             }

        }



    }
}