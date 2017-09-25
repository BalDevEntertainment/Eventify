package com.baldev.eventify.domain.entities;


import android.support.annotation.NonNull;

import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;
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
	@Mock
	private String groupId;
	private String validGroupName = "Group Name";

	@Before
	public void setUp() throws Exception {
		userList.add(user);
		when(user.getId()).thenReturn("1");
		when(differentUser.getId()).thenReturn("2");
	}

	@Test
	public void givenValidUserListName_WhenNewGroup_ThenGroupHasThatAmountOfUsers() throws InvalidGroupNameException {
		Group group = buildValidGroup();
		assertEquals(group.getUsers().size(), userList.size());
	}

	@Test
	public void givenValidGroupName_WhenNewGroup_ThenGroupHasThatName() throws InvalidGroupNameException {
		Group group = buildValidGroup();
		assertEquals(group.getName(), validGroupName);
	}

	@Test(expected = InvalidGroupNameException.class)
	public void givenInvalidGroupName_WhenNewGroup_ThenThrowInvalidGroupNameException() throws InvalidGroupNameException {
		new Group(groupId, "", userList);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullUserList_WhenNewGroup_ThenThrowNullPointerException() throws InvalidGroupNameException {
		new Group(groupId, validGroupName, null);
	}

	@Test(expected = UserNotFoundException.class)
	public void whenGetUser_ThenThrowUserNotFoundException() throws UserNotFoundException, InvalidGroupNameException {
		Group group = buildValidGroup();
		group.addUsers(userList);
		group.getUser(differentUser);
	}

	@NonNull
	private Group buildValidGroup() throws InvalidGroupNameException {
		return new Group(groupId, validGroupName, userList);
	}

	@Test()
	public void whenGetUser_ThenReturnUser() throws UserNotFoundException, InvalidGroupNameException {
		Group group = buildValidGroup();
		group.addUsers(userList);
		Assert.assertEquals(group.getUser(user), user);
	}
}
