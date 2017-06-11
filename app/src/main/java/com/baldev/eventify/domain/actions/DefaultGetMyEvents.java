package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.actions.users.GetMyUserAction;
import com.baldev.eventify.domain.entities.Event;
import com.baldev.eventify.domain.repositories.EventsRepository;

import java.util.List;


public class DefaultGetMyEvents implements GetMyEvents {
	private final EventsRepository repository;
	private final GetMyUserAction getMyUserAction;

	public DefaultGetMyEvents(EventsRepository repository, GetMyUserAction getMyUserAction) {
		this.repository = repository;
		this.getMyUserAction = getMyUserAction;
	}

	@Override
	public List<Event> execute() {
		return repository.getEventsByUserId(getMyUserAction.execute().getId());

	}
}
