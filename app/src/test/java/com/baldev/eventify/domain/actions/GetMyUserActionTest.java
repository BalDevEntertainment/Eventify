package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.actions.users.DefaultGetMyUserAction;
import com.baldev.eventify.domain.actions.users.GetMyUserAction;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.UsersRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetMyUserActionTest {

	@Mock
	private UsersRepository usersRepository;

	@Before
	public void setUp() throws Exception {
		when(usersRepository.getMyUser()).thenReturn(mock(User.class));
	}

	@Test
	public void whenGetMyUserAction_ThenUserIsNotNull () {
		GetMyUserAction getMyUserAction = new DefaultGetMyUserAction(usersRepository);
		assertNotNull(getMyUserAction.execute());
	}
}