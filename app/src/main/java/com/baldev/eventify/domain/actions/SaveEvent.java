package com.baldev.eventify.domain.actions;


import com.baldev.eventify.domain.entities.Group;

public interface SaveEvent {
	void execute(Group group, String description, int date, int duration);
}
