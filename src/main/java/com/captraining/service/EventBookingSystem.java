package com.captraining.service;

import com.captraining.entity.Attendee;
import com.captraining.entity.Event;
import com.captraining.entity.Organizer;
import com.captraining.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

public class EventBookingSystem {

    List<Attendee> attendees;
    List<Organizer> organizers;
    List<Event> events;
    List<Ticket> tickets;

    public EventBookingSystem() {
        this.attendees = new ArrayList<>();
        this.organizers = new ArrayList<>();
        this.events = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }


}
