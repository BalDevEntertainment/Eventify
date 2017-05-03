package com.baldev.eventify.domain.actions;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.services.SaveEventService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SaveEventTest {

	@Mock
	private Group group;

	@Mock
	private SaveEventService saveEventService;

	private int duration = 1;
	private int date = 1;
	private String description = "Event description";

	@Test
	public void whenSaveEvent_ThenSaveEventServiceIsCalledOnce () {
		SaveEvent saveEvent = new DefaultSaveEvent(saveEventService);
		saveEvent.execute(group, description, date, duration);
		verify(saveEventService, times(1)).saveEvent(group, description, date, duration);
	}
}
