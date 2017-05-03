package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.repositories.EventsRepository;
import com.baldev.eventify.domain.entities.Group;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SaveEventServiceTest {

	@Mock
	private Group group;

	@Mock
	private EventsRepository eventsRepository;

	private int duration = 1;
	private int date = 1;
	private String description = "Event description";

	@Test
	public void whenSaveEvent_ThenSaveRepositoryIsCalledOnce () {
		SaveEventService saveEventService = new SaveEventService(eventsRepository);
		saveEventService.saveEvent(group, description, date, duration);
		verify(eventsRepository, times(1)).saveEvent(group, description, date, duration);
	}
}