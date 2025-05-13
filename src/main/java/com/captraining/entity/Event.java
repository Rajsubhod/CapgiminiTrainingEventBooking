package com.captraining.entity;

public class Event {
	private String title;
	private int availableTickets;
	public Event(String title, int availableTickets) {
		this.title=title;
		this.availableTickets=availableTickets;
	}
	public boolean isAvailable() {
		return availableTickets>0;
	}
	public void setAvailableTickets(int tickets) {
		this.availableTickets=tickets;
	}
	public String getTitle() {
		return title;
	}
	public int getAvailabeTickets() {
		return availableTickets;
	}
	@Override
	public String toString() {
		return "Event [title=" + title + ", availableTickets=" + availableTickets + "]";
	}
	
	
}
