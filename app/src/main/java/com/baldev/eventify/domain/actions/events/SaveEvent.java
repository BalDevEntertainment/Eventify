package com.baldev.eventify.domain.actions.events;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.exceptions.NoGroupSelectedException;
import com.baldev.eventify.domain.services.SaveEventService;
import com.google.common.base.Preconditions;

import java.util.Date;

public class SaveEvent {
	private SaveEventService saveEventService;

	public SaveEvent(SaveEventService saveEventService) {
		Preconditions.checkNotNull(saveEventService);
		this.saveEventService = saveEventService;
	}

	public void execute(Group group, String description, Date date, int duration) throws NoGroupSelectedException {
		saveEventService.saveEvent(group, description, date, duration);
	}
}
