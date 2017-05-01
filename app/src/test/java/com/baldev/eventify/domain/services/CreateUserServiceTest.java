package com.baldev.eventify.domain.services;


import com.baldev.eventify.domain.entities.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserServiceTest {

	private CreateUserService createUserService;
	private String userName = "User Name";

	@Before
	public void setUp() throws Exception {
		createUserService = new CreateUserService();
	}

	@Test
	public void givenValidUserName_whenCreateUser_ThenUserIsCreated() {
		User user = createUserService.createUser(userName);
		assertNotNull(user);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullUserName_whenCreateUser_ThenThrowNullPointerException() {
		createUserService.createUser(null);
	}
}
