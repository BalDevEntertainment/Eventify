package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.actions.users.GetMyUser;
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
public class GetMyUserTest {

	@Mock
	private UsersRepository usersRepository;

	@Before
	public void setUp() throws Exception {
		when(usersRepository.getMyUser()).thenReturn(mock(User.class));
	}

	@Test
	public void whenGetMyUserAction_ThenUserIsNotNull () {
		GetMyUser getMyUser = new GetMyUser(usersRepository);
		assertNotNull(getMyUser.execute());
	}
}