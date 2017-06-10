package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.entities.Event;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.exceptions.NoGroupSelectedException;
import com.google.common.base.Preconditions;

import java.util.Date;

public class CreateEventService {
	public Event createEvent(Group group, String description, Date date, int duration) throws NoGroupSelectedException {
		Preconditions.checkNotNull(description);
		Preconditions.checkNotNull(date);
		Preconditions.checkArgument(duration >= 0);
		if(group == null){
			throw new NoGroupSelectedException();
		}
		return new Event(group, description, date, duration);
	}
}
