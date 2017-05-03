package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.repositories.EventsRepository;

import javax.inject.Inject;

public class SaveEventService {
	private EventsRepository eventsRepository;

	@Inject
	public SaveEventService(EventsRepository eventsRepository) {
		this.eventsRepository = eventsRepository;
	}

	public void saveEvent(Group group, String description, int date, int duration) {
		eventsRepository.saveEvent(group, description, date, duration);
	}
}
