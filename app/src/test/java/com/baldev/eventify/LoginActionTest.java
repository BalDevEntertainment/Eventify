package com.baldev.eventify;

import com.baldev.eventify.domain.actions.LoginAction;
import com.baldev.eventify.domain.actions.LoginCallback;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.LoginService;

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
public class LoginActionTest {

	@Mock
	private LoginCallback loginCallback;

	@Mock
	private User validUser;

	@Mock
	private User invalidUser;

	@Mock
	private LoginService loginService;

	@InjectMocks
	private LoginAction loginAction;

	private Answer<Void> onLoginSuccessfulAnswer = new LoginSuccessfulAnswer();
	private Answer<Void> onLoginFailedAnswer = new LoginFailedAnswer();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		doAnswer(onLoginSuccessfulAnswer).when(loginService).login(validUser, loginCallback);
		doAnswer(onLoginFailedAnswer).when(loginService).login(invalidUser, loginCallback);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullLoginService_whenCreateLoginAction_ThenThrowNullPointerException() {
		new LoginAction(null);
	}

	@Test
	public void givenValidParameters_whenExecute_ThenOnLoginSuccessfulCalledOnce() {
		loginAction.execute(validUser, loginCallback);
		verify(loginCallback, times(1)).onLoginSuccessful();
	}

	@Test(expected = NullPointerException.class)
	public void givenNullUser_whenExecute_ThenThrowNullPointerException() {
		loginAction.execute(null, loginCallback);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullListener_whenExecute_ThenThrowNullPointerException() {
		loginAction.execute(validUser, null);
	}

	@Test
	public void givenInvalidUser_whenExecute_ThenOnLoginFailedCalledOnce() {
		loginAction.execute(invalidUser, loginCallback);
		verify(loginCallback, times(1)).onLoginFailed();
	}

	private static final class LoginSuccessfulAnswer implements Answer<Void> {
		@Override
		public Void answer(InvocationOnMock invocation) throws Throwable {
			LoginCallback loginCallback = (LoginCallback) invocation.getArguments()[1];
			loginCallback.onLoginSuccessful();
			return null;
		}
	}

	private static final class LoginFailedAnswer implements Answer<Void> {
		@Override
		public Void answer(InvocationOnMock invocation) throws Throwable {
			LoginCallback loginCallback = (LoginCallback) invocation.getArguments()[1];
			loginCallback.onLoginFailed();
			return null;
		}
	}
}