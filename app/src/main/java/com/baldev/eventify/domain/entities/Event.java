package com.baldev.eventify.domain.entities;


import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Date;

@IgnoreExtraProperties
public class Event {
	private String id;
	private final Group group;
	private final String description;
	private final Date date;
	private final int duration;

	public Event(String id, Group group, String description, Date date, int duration) {
		this.id = id;
		this.group = group;
		this.description = description;
		this.date = date;
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}
}
