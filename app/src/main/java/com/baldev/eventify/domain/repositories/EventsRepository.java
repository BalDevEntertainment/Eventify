package com.baldev.eventify.domain.repositories;


import com.baldev.eventify.domain.entities.Event;

import java.util.List;

public interface EventsRepository {
	void saveEvent(Event event);

	List<Event> getEventsByUserId(int id);
}
