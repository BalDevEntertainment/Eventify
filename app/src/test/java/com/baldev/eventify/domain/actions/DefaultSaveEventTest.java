package com.baldev.eventify.domain.actions;


import com.baldev.eventify.domain.actions.events.DefaultSaveEvent;
import com.baldev.eventify.domain.actions.events.SaveEvent;
import com.baldev.eventify.domain.entities.Event;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.exceptions.NoGroupSelectedException;
import com.baldev.eventify.domain.services.CreateEventService;
import com.baldev.eventify.domain.services.SaveEventService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultSaveEventTest {

	@Mock
	private Group group;
	@Mock
	private SaveEventService saveEventService;
	@Mock
	private Date date;
	@Mock
	private Event event;
	@Mock
	private CreateEventService createEventService;

	private int duration = 1;
	private String description = "Event description";

	@Test(expected = NullPointerException.class)
	public void givenNullCreateEventService_whenSaveEvent_ThenThrowNullPointerException() {
		new DefaultSaveEvent(null, saveEventService);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullSaveEventService_whenSaveEvent_ThenThrowNullPointerException() {
		new DefaultSaveEvent(createEventService, null);
	}

	@Test
	public void whenSaveEvent_ThenSaveEventServiceIsCalledOnce() throws NoGroupSelectedException {
		SaveEvent saveEvent = new DefaultSaveEvent(createEventService, saveEventService);
		when(createEventService.createEvent(group, description, date, duration)).thenReturn(event);
		saveEvent.execute(group, description, date, duration);
		verify(createEventService, times(1)).createEvent(group, description, date, duration);
		verify(saveEventService, times(1)).saveEvent(event);
	}
}
