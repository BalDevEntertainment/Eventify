package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.actions.events.GetMyEvents;
import com.baldev.eventify.domain.actions.users.GetMyUser;
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
public class GetMyEventsTest {

	@Mock
	private EventsRepository eventsRepository;
	@Mock
	private GetMyUser getMyUser;

	@Test()
	public void whenExecuteThenReturnGroups(){
		User user = Mockito.mock(User.class);
		when(getMyUser.execute()).thenReturn(user);
		when(user.getId()).thenReturn("1");
		new GetMyEvents(eventsRepository, getMyUser).execute();
		verify(eventsRepository, times(1)).getEventsByUserId(user.getId());
	}
}