package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.Event;

import java.util.List;

public interface GetMyEvents {
	List<Event> execute();
}
