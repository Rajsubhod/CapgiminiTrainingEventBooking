package com.captraining.service;

import java.awt.Event;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import src.main.java.com.captraining.entity.Attendee;
import src.main.java.com.captraining.entity.Organizer;
import src.main.java.com.captraining.entity.Ticket;
public class EventBookingSystem {

    List<Attendee> attendees;
    List<Organizer> organizers;
    List<jdk.jfr.Event> events;
    List<Ticket> tickets;

    public EventBookingSystem() {
        this.attendees = new ArrayList<>();
        this.organizers = new ArrayList<>();
        this.events = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }
    public void addEvent(jdk.jfr.Event event) {
    	events.add(event);
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
    		events=(List<jdk.jfr.Event>)in.readObject();
    	}
    	catch(Exception e) {
    		System.out.println("no saved events found.");
    	}
    }
    
}
