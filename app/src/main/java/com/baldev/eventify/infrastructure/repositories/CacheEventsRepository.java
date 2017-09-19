package com.baldev.eventify.infrastructure.repositories;


import com.baldev.eventify.domain.entities.Event;
import com.baldev.eventify.domain.repositories.EventsRepository;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Optional.fromNullable;

public class CacheEventsRepository implements EventsRepository {
	private static EventsRepository instance;
	private List<Event> events = new ArrayList<>();

	public static EventsRepository getInstance() {
		return fromNullable(instance).or(() -> {
			instance = new CacheEventsRepository();
			return instance;
		});
	}

	@Override
	public void saveEvent(Event event) {
		events.add(event);
	}

	@Override
	public List<Event> getEventsByUserId(String id) {
		return events;
	}
}
