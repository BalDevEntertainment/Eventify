package com.baldev.eventify.domain.entities;


import android.support.annotation.NonNull;

import com.baldev.eventify.domain.exceptions.InvalidUserNameException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

	private String userName = "UserName";
	private String validId = "ValidId";
	private User validUser;

	@Before
	public void setUp() throws Exception {
		validUser = buildUser(validId, userName);
	}

	@Test
	public void givenValidUserName_WhenNewUser_ThenUserHasThatUserName() {
		assertEquals(validUser.getName(), userName);
	}

	@Test
	public void givenValidUserId_WhenNewUser_ThenUserHasThatUserId() {
		assertEquals(validUser.getId(), validId);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullUserName_WhenNewUser_ThenThrowNullPointerException() {
		buildUser(validId, null);
	}

	@Test(expected = InvalidUserNameException.class)
	public void givenEmptyUserName_WhenNewUser_ThenThrowInvalidUserNameException() throws InvalidUserNameException {
		new User(validId, "");
	}

	@Test(expected = InvalidUserNameException.class)
	public void givenUserNameWithOnlySpaces_WhenNewUser_ThenThrowInvalidUserNameException() throws InvalidUserNameException {
		new User(validId, " ");
	}

	@Test
	public void equals() {
		assertEquals(validUser, validUser);
	}

	@Test
	public void notEquals() {
		String differentId = "DifferentId";
		assertFalse(validUser.equals(buildUser(differentId, userName)));
	}

	@SuppressWarnings("EqualsBetweenInconvertibleTypes")
	@Test
	public void compareDifferentTypes() {
		Group differentObject = Mockito.mock(Group.class);
		User user = buildUser(validId, userName);
		assertFalse(user.equals(differentObject));
	}

	@NonNull
	private User buildUser(String id, String username) {
		try {
			return new User(id, username);
		} catch (InvalidUserNameException e) {
			return null;
		}
	}
}
