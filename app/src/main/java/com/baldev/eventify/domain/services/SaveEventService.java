package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.entities.Event;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.repositories.EventsRepository;

import java.util.Date;

import javax.inject.Inject;

public class SaveEventService {
	private EventsRepository eventsRepository;

	@Inject
	public SaveEventService(EventsRepository eventsRepository) {
		this.eventsRepository = eventsRepository;
	}

	public void saveEvent(Event event) {
		eventsRepository.saveEvent(event);
	}
}
