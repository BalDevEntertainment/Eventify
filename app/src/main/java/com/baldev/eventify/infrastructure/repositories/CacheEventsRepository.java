package com.baldev.eventify.infrastructure.repositories;


import com.baldev.eventify.domain.entities.Event;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.repositories.EventsRepository;
import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory.InitializeRepositoriesCallback;

import java.util.ArrayList;
import java.util.Date;
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
	public List<Event> getEventsByUserId(String id) {
		return events;
	}

	@Override
	public void initialize(InitializeRepositoriesCallback callback) {

	}

	@Override
	public Event saveEvent(Group group, String description, Date date, int duration) {
		Event event = new Event("DummyEventId", group, description, date, duration);
		events.add(event);
		return event;
	}
}
