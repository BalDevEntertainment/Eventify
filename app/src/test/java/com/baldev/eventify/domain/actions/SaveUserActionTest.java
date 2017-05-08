package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.actions.users.DefaultSaveUserAction;
import com.baldev.eventify.domain.actions.users.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidUserNameException;
import com.baldev.eventify.domain.services.CreateUserService;
import com.baldev.eventify.domain.services.SaveUserService;

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
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SaveUserActionTest {

	@Mock
	private SaveUserCallback saveUserCallback;

	@Mock
	private User validUser;

	@Mock
	private SaveUserService saveUserService;

	@Mock
	private CreateUserService createUserService;

	private String validUsername = "UserName";

	@InjectMocks
	private DefaultSaveUserAction saveUserAction;
	private Answer<Void> saveUserSuccessfulAnswer = new SaveUserSuccessfulAnswer();

	@Before
	public void setUp() throws Exception, InvalidUserNameException {
		MockitoAnnotations.initMocks(this);
		when(createUserService.createUser(validUsername)).thenReturn(validUser);
		doAnswer(saveUserSuccessfulAnswer).when(saveUserService).saveUser(validUser, saveUserCallback);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullSaveUserService_whenCreateCreateUserAction_ThenThrowNullPointerException() {
		new DefaultSaveUserAction(createUserService, null);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullCreateUserService_whenCreateCreateUserAction_ThenThrowNullPointerException() {
		new DefaultSaveUserAction(null, saveUserService);
	}

	@Test
	public void givenValidUser_WhenCreateUserActionIsExecuted_ThenOnUserCreatedIsCalled() throws InvalidUserNameException {
		saveUserAction.execute(validUsername, saveUserCallback);
		verify(saveUserCallback, times(1)).onUserSaved();
	}

	private static final class SaveUserSuccessfulAnswer implements Answer<Void> {
		@Override
		public Void answer(InvocationOnMock invocation) throws Throwable {
			SaveUserCallback callback = (SaveUserCallback) invocation.getArguments()[1];
			callback.onUserSaved();
			return null;
		}
	}
}
