package com.baldev.eventify.domain.actions;


import com.baldev.eventify.domain.actions.events.SaveEvent;
import com.baldev.eventify.domain.entities.Event;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.exceptions.NoGroupSelectedException;
import com.baldev.eventify.domain.services.SaveEventService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SaveEventTest {

	@Mock
	private Group group;
	@Mock
	private SaveEventService saveEventService;
	@Mock
	private Date date;
	@Mock
	private Event event;

	private int duration = 1;
	private String description = "Event description";

	@Test(expected = NullPointerException.class)
	public void givenNullSaveEventService_whenSaveEvent_ThenThrowNullPointerException() {
		new SaveEvent(null);
	}

	@Test
	public void whenSaveEvent_ThenSaveEventServiceIsCalledOnce() throws NoGroupSelectedException {
		SaveEvent saveEvent = new SaveEvent(saveEventService);
		saveEvent.execute(group, description, date, duration);
		verify(saveEventService, times(1)).saveEvent(group, description, date, duration);
	}
}
