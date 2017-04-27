package com.baldev.eventify;

import com.baldev.eventify.domain.actions.LoginCallback;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.LoginService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

	@Mock
	private LoginCallback loginCallback;

	@Mock
	private User validUser;

	@Mock
	private User invalidUser;

	@InjectMocks
	private LoginService loginService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void givenValidParameters_whenExecute_ThenOnLoginSuccessfulCalledOnce() {
		loginService.execute(validUser, loginCallback);
		verify(loginCallback, times(1)).onLoginSuccessful();
	}
}