package com.baldev.eventify.domain.entities;


import android.support.annotation.NonNull;

import com.baldev.eventify.domain.exceptions.InvalidUserNameException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotSame;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

	private String userName = "UserName";
	private int validId = 1;
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
		int differentId = 2;
		assertFalse(validUser.equals(buildUser(differentId, userName)));
	}

	@NonNull
	private User buildUser(int id, String username) {
		try {
			return new User(id, username);
		} catch (InvalidUserNameException e) {
			return null;
		}
	}
}
