package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.Event;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.exceptions.NoGroupSelectedException;
import com.baldev.eventify.domain.services.CreateEventService;
import com.baldev.eventify.domain.services.SaveEventService;
import com.google.common.base.Preconditions;

import java.util.Date;

public class DefaultSaveEvent implements SaveEvent {
	private SaveEventService saveEventService;
	private CreateEventService createEventService;

	public DefaultSaveEvent(CreateEventService createEventService, SaveEventService saveEventService) {
		Preconditions.checkNotNull(createEventService);
		Preconditions.checkNotNull(saveEventService);
		this.saveEventService = saveEventService;
		this.createEventService = createEventService;
	}

	@Override
	public void execute(Group group, String description, Date date, int duration) throws NoGroupSelectedException {
		Event event = createEventService.createEvent(group, description, date, duration);
		saveEventService.saveEvent(event);
	}
}
