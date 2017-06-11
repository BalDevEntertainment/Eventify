package com.baldev.eventify.presentation.mainactivity.events;


import com.baldev.eventify.domain.actions.events.GetMyEvents;
import com.baldev.eventify.domain.entities.Event;

import java.util.List;

public class EventsFragmentPresenter {

	protected List<Event> events;
	private EventsFragment view;
	private GetMyEvents getMyEvents;

	public EventsFragmentPresenter(EventsFragment view, GetMyEvents getMyEvents) {
		this.view = view;
		this.getMyEvents = getMyEvents;
		retrieveEventList();
	}

	public void onViewCreated() {
		initializeGroupListAdapter(view);
	}

	public void onResume() {
		retrieveEventList();
		initializeGroupListAdapter(view);
	}

	private void retrieveEventList() {
		events = getMyEvents.execute();
	}

	private void initializeGroupListAdapter(EventsFragment view) {
		view.setEventListToAdapter(events);
	}
}
