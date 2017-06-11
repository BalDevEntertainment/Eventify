package com.baldev.eventify.domain.services;

import android.support.annotation.NonNull;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.exceptions.NoGroupSelectedException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;
import java.util.regex.Matcher;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CreateEventServiceTest {

	@Mock
	private Date date;
	@Mock
	private Group group;
	private int durationInHours = 1;
	private String eventDescription = "Event Description";
	private CreateEventService service;

	@Before
	public void setUp() throws Exception {
		service = buildCreateEventService();
	}

	@Test
	public void whenCreateEventService_ThenReturnCreateEventService() {
		assertNotNull(buildCreateEventService());
	}

	@Test
	public void whenExecute_ThenReturnEvent() {
		CreateEventService service = buildCreateEventService();
		assertNotNull(service.createEvent(group, eventDescription, date, durationInHours));
	}

	@Test(expected = NoGroupSelectedException.class)
	public void givenNullGroup_whenCreateEvent_ThenThrowNoGroupSelectedException() throws NoGroupSelectedException {
		service.createEvent(null, eventDescription, date, durationInHours);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullEventDescription_whenCreateEvent_ThenThrowNullPointerException() throws NoGroupSelectedException {
		service.createEvent(group, null, date, durationInHours);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullDate_whenCreateEvent_ThenThrowNullPointerException() throws NoGroupSelectedException {
		service.createEvent(group, eventDescription, null, durationInHours);
	}

	@Test(expected = IllegalArgumentException.class)
	public void givenNegativeDurationInHours_whenCreateEvent_ThenThrowIllegalArgumentException() throws NoGroupSelectedException {
		service = buildCreateEventService();
		service.createEvent(group, eventDescription, date, -1);
	}

	@NonNull
	private CreateEventService buildCreateEventService() {
		return new CreateEventService();
	}
}