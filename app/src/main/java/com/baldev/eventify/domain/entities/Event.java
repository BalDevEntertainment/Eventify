package com.baldev.eventify.domain.entities;


import java.util.Date;

public class Event {
	private final Group group;
	private final String description;
	private final Date date;
	private final int duration;

	public Event(Group group, String description, Date date, int duration) {
		this.group = group;
		this.description = description;
		this.date = date;
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}
}
