package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.services.SaveEventService;

class DefaultSaveEvent implements SaveEvent {
	private SaveEventService saveEventService;

	public DefaultSaveEvent(SaveEventService saveEventService) {
		this.saveEventService = saveEventService;
	}

	@Override
	public void execute(Group group, String description, int date, int duration) {
		saveEventService.saveEvent(group, description, date, duration);
	}
}
