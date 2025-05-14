package com.captraining.service;

import com.captraining.entity.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
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

    

    public List<Attendee> getAttendees() {
        return attendees;
    }



    public List<Organizer> getOrganizers() {
        return organizers;
    }



    public List<Event> getEvents() {
        return events;
    }



    public List<Ticket> getTickets() {
        return tickets;
    }



    public void saveEvents() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("events.json"), events);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addEvent(Event event) {
        events.add(event);
    }
  
	public void loadEvents() {
    	try{
            ObjectMapper objectMapper = new ObjectMapper();
            events = objectMapper.readValue(new File("events.json"), new TypeReference<>() {
            });
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
