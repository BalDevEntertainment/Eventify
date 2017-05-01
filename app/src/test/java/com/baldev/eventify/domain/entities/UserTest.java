package com.baldev.eventify.domain.entities;


import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

	@Test
	public void givenValidUserName_WhenNewUser_ThenUserHasThatUserName() {
		String userName = "UserName";
		User user = new User(userName);
		Assert.assertEquals(user.getName(), userName);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullUserName_WhenNewUser_ThenThrowNullPointerException() {
		new User(null);
	}
}
