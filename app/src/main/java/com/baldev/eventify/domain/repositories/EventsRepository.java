package com.baldev.eventify.domain.repositories;


import com.baldev.eventify.domain.entities.Group;

public interface EventsRepository {
	void saveEvent(Group group, String description, int date, int duration);
}
