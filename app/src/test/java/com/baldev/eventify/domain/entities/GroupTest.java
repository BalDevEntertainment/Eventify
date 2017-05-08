package com.baldev.eventify.domain.entities;


import com.baldev.eventify.domain.exceptions.UserNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GroupTest {

	private List<User> userList = new ArrayList<>();

	@Mock
	private User user;

	@Mock
	private User differentUser;

	@Before
	public void setUp() throws Exception {
		userList.add(user);
		when(user.getId()).thenReturn(1);
		when(differentUser.getId()).thenReturn(2);
	}

	@Test
	public void givenValidUserListName_WhenNewGroup_ThenGroupHasThatAmoutOfUsers() {
		Group group = new Group(userList);
		assertEquals(group.getUsers().size(), userList.size());
	}

	@Test(expected = NullPointerException.class)
	public void givenNullUserList_WhenNewGroup_ThenThrowNullPointerException() {
		new Group(null);
	}

	@Test(expected = UserNotFoundException.class)
	public void whenGetUser_ThenThrowUserNotFoundException() throws UserNotFoundException {
		Group group = new Group(userList);
		group.addUsers(userList);
		group.getUser(differentUser);
	}

	@Test()
	public void whenGetUser_ThenReturnUser() throws UserNotFoundException {
		Group group = new Group(userList);
		group.addUsers(userList);
		Assert.assertEquals(group.getUser(user), user);
	}
}
