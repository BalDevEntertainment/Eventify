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

	private List<User> emptyUserList = new ArrayList<>();
	private List<User> userList = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		userList.add(Mockito.mock(User.class));
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
}
