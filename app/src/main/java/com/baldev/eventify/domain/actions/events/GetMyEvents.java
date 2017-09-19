package com.baldev.eventify.domain.actions.events;

import com.baldev.eventify.domain.actions.users.GetMyUser;
import com.baldev.eventify.domain.entities.Event;
import com.baldev.eventify.domain.repositories.EventsRepository;

import java.util.List;


public class GetMyEvents {
	private final EventsRepository repository;
	private final GetMyUser getMyUser;

	public GetMyEvents(EventsRepository repository, GetMyUser getMyUser) {
		this.repository = repository;
		this.getMyUser = getMyUser;
	}

	public List<Event> execute() {
		return repository.getEventsByUserId(getMyUser.execute().getId());
	}
}
