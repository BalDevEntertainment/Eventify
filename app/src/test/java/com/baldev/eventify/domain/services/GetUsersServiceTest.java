package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.GetUsersCallback;
import com.baldev.eventify.domain.repositories.UsersRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GetUsersServiceTest {

	private static List<User> emptyUsersList = new ArrayList<>();

	@Mock
	private UsersRepository usersRepository;

	@Mock
	private GetUsersCallback getUsersCallback;

	@InjectMocks
	private GetUsersService getMyUserService;

	private Answer<Void> getUsersAnswer = new GetUsersAnswer();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		doAnswer(getUsersAnswer).when(usersRepository).getUsers(getUsersCallback);
	}

	@Test
	public void whenGetUsers_ThenReturnUserList () {
		getMyUserService.getUsers(getUsersCallback);
		verify(getUsersCallback, times(1)).onUsersRetrieved(eq(emptyUsersList));
	}

	private static final class GetUsersAnswer implements Answer<Void> {
		@Override
		public Void answer(InvocationOnMock invocation) throws Throwable {
			GetUsersCallback callback = (GetUsersCallback) invocation.getArguments()[0];
			callback.onUsersRetrieved(emptyUsersList);
			return null;
		}
	}
}