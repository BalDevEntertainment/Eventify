package com.baldev.eventify.domain.repositories;


import com.baldev.eventify.domain.entities.Event;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory.InitializeRepositoriesCallback;

import java.util.Date;
import java.util.List;

public interface EventsRepository {

	List<Event> getEventsByUserId(String id);

	void initialize(InitializeRepositoriesCallback callback);

	Event saveEvent(Group group, String description, Date date, int duration);
}
