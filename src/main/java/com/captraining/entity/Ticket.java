package com.captraining.entity;

public class Ticket {
	Attendee attendee;
	Event event ;
	String status;
	public Ticket(Attendee attendee,Event event) {
		this.attendee=attendee;
		this.event =event ;
		this.status="Booked";
	}
	void cancel() {
		this.status="Cancelled";
	}
	String getStatus() {
		return status;
	}
	String ticketDetails() {
		return "Ticket for "+attendee.id+ " to "+event.getTitle()+" -Status: "+status;
	}
}
