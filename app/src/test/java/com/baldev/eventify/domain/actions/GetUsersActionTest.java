package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.actions.users.DefaultGetUsersAction;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.GetUsersCallback;
import com.baldev.eventify.domain.repositories.UsersRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GetUsersActionTest {

	private static List<User> emptyUserList = new ArrayList<>();

	@Mock
	private UsersRepository usersRepository;

	@Mock
	private GetUsersCallback callback;

	@InjectMocks
	private DefaultGetUsersAction getUsersAction;

	private Answer<Void> getUsersAnswer = new GetUsersAnswer();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		doAnswer(getUsersAnswer).when(usersRepository).getUsers(callback);
	}

	@Test
	public void whenGetUsersActionIsExecuted_ThenGetUserList() {
		getUsersAction.execute(callback);
		verify(callback, times(1)).onUsersRetrieved(emptyUserList);
	}

	private static final class GetUsersAnswer implements Answer<Void> {
		@Override
		public Void answer(InvocationOnMock invocation) throws Throwable {
			GetUsersCallback callback = (GetUsersCallback) invocation.getArguments()[0];
			callback.onUsersRetrieved(emptyUserList);
			return null;
		}
	}
}