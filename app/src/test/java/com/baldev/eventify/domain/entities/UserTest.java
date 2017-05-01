package com.baldev.eventify.domain.entities;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

	private String userName = "UserName";
	private int validId = 1;

	@Test
	public void givenValidUserName_WhenNewUser_ThenUserHasThatUserName() {
		User user = new User(1, userName);
		assertEquals(user.getName(), userName);
	}

	@Test
	public void givenValidUserId_WhenNewUser_ThenUserHasThatUserId() {
		User user = new User(validId, userName);
		assertEquals(user.getId(), validId);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullUserName_WhenNewUser_ThenThrowNullPointerException() {
		new User(1, null);
	}
}
