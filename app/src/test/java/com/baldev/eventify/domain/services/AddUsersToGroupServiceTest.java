package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.UserNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddUsersToGroupServiceTest {

	@Mock
	private Group group;
	@Mock
	private User user;

	@Before
	public void setUp() throws Exception, UserNotFoundException {
		when(group.getUser(user)).thenReturn(user);
	}

	@Test
	public void whenAddUsersToGroup_ThenUserIsAdded () throws UserNotFoundException {
		AddUsersToGroupService addUsersToGroupService = new AddUsersToGroupService();
		List<User> users = new ArrayList<>();
		users.add(user);
		addUsersToGroupService.addUsersToGroup(group, users);
		assertEquals(group.getUser(user), user);
	}
}