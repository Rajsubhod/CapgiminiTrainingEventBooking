package com.captraining.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import src.main.java.com.captraining.entity.Event;
import src.main.java.com.captraining.entity.Attendee;
import src.main.java.com.captraining.entity.Organizer;
import src.main.java.com.captraining.entity.Ticket;
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

    public void saveEvents() {
    	try(ObjectOutputStream out =new ObjectOutputStream(new FileOutputStream("events.ser")))	{
    		out.writeObject(events);
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }
  
	public void loadEvents() {
    	try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("events.ser"))){
    		events=(List<Event>)in.readObject();
    	}
    	catch(Exception e) {
    		System.out.println("no saved events found.");
    	}
    }
	
    public void addEvent(Event event) {
        events.add(event);
    }

    public void showEvents() {
        for (Event event : events) {
            System.out.println(event);
        }
    }

    public void addAttendee(Attendee attendee) {
        attendees.add(attendee);
    }

}
