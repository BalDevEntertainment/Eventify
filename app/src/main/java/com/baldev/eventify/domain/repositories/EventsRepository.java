package com.baldev.eventify.domain.repositories;


import com.baldev.eventify.domain.entities.Event;

public interface EventsRepository {
	void saveEvent(Event event);
}
