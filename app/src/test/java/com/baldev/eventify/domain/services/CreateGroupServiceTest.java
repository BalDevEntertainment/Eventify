package com.baldev.eventify.domain.services;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CreateGroupServiceTest {

	private String groupName = "Group Name";
	private List<User> emptyUserList = new ArrayList<>();
	private List<User> userList = new ArrayList<>();

	@InjectMocks
	private CreateGroupService createGroupService;

	@Mock
	private User mockUser;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		createGroupService = new CreateGroupService();
		userList.add(mockUser);
		userList.add(mockUser);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullGroupName_whenCreateGroup_ThenThrowNullPointerException() {
		createGroupService.createGroup(null, emptyUserList);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullUsersList_whenCreateGroup_ThenThrowNullPointerException() {
		createGroupService.createGroup(groupName, null);
	}

	@Test()
	public void givenUserList_whenCreateGroup_ThenGroupContainsThoseUsers() {
		Group group = createGroupService.createGroup(groupName, userList);
		assertEquals(group.getUsers().size(), userList.size());
	}

	@Test
	public void givenValidArguments_whenCreateGroup_ThenReturnGroup() {
		Group group = createGroupService.createGroup(groupName, userList);
		assertNotNull(group);
	}
}
