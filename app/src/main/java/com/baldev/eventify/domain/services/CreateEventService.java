package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.entities.Event;
import com.baldev.eventify.domain.entities.Group;
import com.google.common.base.Preconditions;

import java.util.Date;

public class CreateEventService {
	public Event createEvent(Group group, String description, Date date, int duration) {
		Preconditions.checkNotNull(group);
		Preconditions.checkNotNull(description);
		Preconditions.checkNotNull(date);
		Preconditions.checkArgument(duration >= 0);
		return new Event(group, description, date, duration);
	}
}
