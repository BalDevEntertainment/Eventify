package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.entities.Event;
import com.baldev.eventify.domain.repositories.EventsRepository;
import com.baldev.eventify.domain.entities.Group;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SaveEventServiceTest {

	@Mock
	private EventsRepository eventsRepository;

	@Mock
	private Event event;

	@Test
	public void whenSaveEvent_ThenSaveRepositoryIsCalledOnce () {
		SaveEventService saveEventService = new SaveEventService(eventsRepository);
		saveEventService.saveEvent(event);
		verify(eventsRepository, times(1)).saveEvent(event);
	}
}