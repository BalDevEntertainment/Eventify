package com.baldev.eventify.domain.actions;


import com.baldev.eventify.domain.entities.Group;

import java.util.Date;

public interface SaveEvent {
	void execute(Group group, String description, Date date, int duration);
}
