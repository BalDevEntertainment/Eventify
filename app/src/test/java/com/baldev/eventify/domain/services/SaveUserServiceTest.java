package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.actions.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;

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
public class SaveUserServiceTest {

	@Mock
	private SaveUserCallback saveUserCallback;

	@Mock
	private User validUser;

	@Mock
	private User invalidUser;

	@InjectMocks
	private SaveUserService saveUserService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void givenValidParameters_whenExecute_ThenOnLoginSuccessfulCalledOnce() {
		saveUserService.saveUser(validUser, saveUserCallback);
		verify(saveUserCallback, times(1)).onUserCreated();
	}
}