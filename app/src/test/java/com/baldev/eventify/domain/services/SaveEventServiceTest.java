package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.repositories.EventsRepository;

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
	private Group group;
	@Mock
	private String description;
	@Mock
	private Date date;
	@Mock
	private int duration;

	@Test
	public void whenSaveEvent_ThenSaveRepositoryIsCalledOnce() {
		SaveEventService saveEventService = new SaveEventService(eventsRepository);
		saveEventService.saveEvent(group, description, date, duration);
		verify(eventsRepository, times(1)).saveEvent(group, description, date, duration);
	}
}