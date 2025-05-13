package com.captraining.service;

import com.captraining.entity.Attendee;
import com.captraining.entity.Event;
import com.captraining.entity.Organizer;
import com.captraining.entity.Ticket;

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
