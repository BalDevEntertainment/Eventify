package com.baldev.eventify.domain.actions.events;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.exceptions.NoGroupSelectedException;

import java.util.Date;

public interface SaveEvent {
	void execute(Group group, String description, Date date, int duration) throws NoGroupSelectedException;
}
