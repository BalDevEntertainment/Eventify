package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.actions.events.DefaultGetMyEvents;
import com.baldev.eventify.domain.actions.users.GetMyUserAction;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.EventsRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultGetMyEventsTest {

	@Mock
	private EventsRepository eventsRepository;
	@Mock
	private GetMyUserAction getMyUserAction;

	@Test()
	public void whenExecuteThenReturnGroups(){
		User user = Mockito.mock(User.class);
		when(getMyUserAction.execute()).thenReturn(user);
		when(user.getId()).thenReturn("1");
		new DefaultGetMyEvents(eventsRepository, getMyUserAction).execute();
		verify(eventsRepository, times(1)).getEventsByUserId(user.getId());
	}
}