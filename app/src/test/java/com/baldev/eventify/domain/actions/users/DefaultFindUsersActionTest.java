package com.baldev.eventify.domain.actions.users;

import com.baldev.eventify.domain.repositories.UsersRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFindUsersActionTest {

	@Mock
	private UsersRepository usersRepository;

	@Test
	public void whenExecute_ThenFindUsersInRepositoryIsCalledOnce() {
		int[] ids = {};
		new DefaultFindUsersAction(usersRepository).execute(ids);
		verify(usersRepository, times(1)).findUsers(ids);
	}
}