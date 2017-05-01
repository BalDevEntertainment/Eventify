package com.baldev.eventify.domain.entities;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GroupTest {

	private String groupName = "Group Name";
	private List<User> emptyUserList = new ArrayList<>();
	private List<User> userList = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		userList.add(Mockito.mock(User.class));
	}

	@Test
	public void givenValidGroupName_WhenNewGroup_ThenGroupHasThatGroupName() {
		Group group = new Group(groupName, userList);
		assertEquals(group.getName(), groupName);
	}

	@Test
	public void givenValidUserListName_WhenNewGroup_ThenGroupHasThatAmoutOfUsers() {
		Group group = new Group(groupName, userList);
		assertEquals(group.getUsers().size(), userList.size());
	}

	@Test(expected = NullPointerException.class)
	public void givenNullGroupName_WhenNewGroup_ThenThrowNullPointerException() {
		new Group(null, userList);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullUserList_WhenNewGroup_ThenThrowNullPointerException() {
		new Group(groupName, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void givenEmptyUserList_WhenNewGroup_ThenThrowIllegalArgumentException() {
		new Group(groupName, emptyUserList);
	}
}
