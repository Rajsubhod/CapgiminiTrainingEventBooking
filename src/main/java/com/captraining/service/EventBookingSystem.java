package com.captraining.service;

import com.captraining.entity.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class EventBookingSystem {

    private List<Attendee> attendees;
    private List<Organizer> organizers;
    private List<Event> events;
    private List<Ticket> tickets;

    public EventBookingSystem() {
        this.attendees = new ArrayList<>();
        this.organizers = new ArrayList<>();
        this.events = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public void saveEvents(Event event) {
    	try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("events.txt")))	{
            events.add(event);
    		out.writeObject(events);
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }
  
	public void loadEvents() {
    	try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("events.txt"))){
    		events=(List<Event>)in.readObject();
    	}
    	catch(Exception e) {
    		System.out.println("no saved events found.");
    	}
    }

    public void showEvents() {
        for (Event event : events) {
            System.out.println(event);
        }
    }

    private void addAttendee(Attendee attendee) {
        attendees.add(attendee);
    }

    private void addOrganizer(Organizer organizer) {
        organizers.add(organizer);
    }

    public void registerUser(User user, Role role){
        if(user instanceof Attendee a){
            addAttendee(a);
        } else if (user instanceof Organizer o) {
            addOrganizer(o);
        }
    }

    public void bookTicket(Attendee attendee, Event event) {
        Ticket ticket = new Ticket(attendee,event);
        tickets.add(ticket);
    }

}
