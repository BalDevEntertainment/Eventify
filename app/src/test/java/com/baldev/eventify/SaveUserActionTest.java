package com.baldev.eventify;

import com.baldev.eventify.domain.actions.SaveUserAction;
import com.baldev.eventify.domain.actions.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;
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

@RunWith(MockitoJUnitRunner.class)
public class SaveUserActionTest {

	@Mock
	private SaveUserCallback saveUserCallback;

	@Mock
	private User validUser;

	@Mock
	private SaveUserService saveUserService;

	@InjectMocks
	private SaveUserAction saveUserAction;

	private Answer<Void> saveUserSuccessfulAnswer = new SaveUserSuccessfulAnswer();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		doAnswer(saveUserSuccessfulAnswer).when(saveUserService).saveUser(validUser, saveUserCallback);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullCreateUserService_whenCreateCreateUserAction_ThenThrowNullPointerException() {
		new SaveUserAction(null);
	}

	@Test
	public void givenValidUser_WhenCreateUserActionIsExecuted_ThenOnUserCreatedIsCalled() {
		saveUserAction.execute(validUser, saveUserCallback);
		verify(saveUserCallback, times(1)).onUserCreated();
	}

	private static final class SaveUserSuccessfulAnswer implements Answer<Void> {
		@Override
		public Void answer(InvocationOnMock invocation) throws Throwable {
			SaveUserCallback callback = (SaveUserCallback) invocation.getArguments()[1];
			callback.onUserCreated();
			return null;
		}
	}
}
