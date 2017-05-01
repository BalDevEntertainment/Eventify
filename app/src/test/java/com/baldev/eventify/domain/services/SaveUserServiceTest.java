package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.actions.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;
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

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SaveUserServiceTest {

	@Mock
	private SaveUserCallback saveUserCallback;

	@Mock
	private UsersRepository usersRepository;

	@Mock
	private User validUser;

	@Mock
	private User invalidUser;

	@InjectMocks
	private SaveUserService saveUserService;

	private Answer<Void> userSavedAnswer = new UserSavedAnswer();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		doAnswer(userSavedAnswer).when(usersRepository).saveUser(validUser, saveUserCallback);
	}

	@Test
	public void givenValidParameters_whenExecute_ThenOnUserSavedCalledOnce() {
		saveUserService.saveUser(validUser, saveUserCallback);
		verify(saveUserCallback, times(1)).onUserSaved();
	}

	private static final class UserSavedAnswer implements Answer<Void> {
		@Override
		public Void answer(InvocationOnMock invocation) throws Throwable {
			SaveUserCallback callback = (SaveUserCallback) invocation.getArguments()[1];
			callback.onUserSaved();
			return null;
		}
	}
}