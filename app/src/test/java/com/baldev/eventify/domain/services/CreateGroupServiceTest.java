package com.baldev.eventify.domain.services;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.GroupsRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CreateGroupServiceTest {

	private List<User> userList = new ArrayList<>();

	@Mock
	private GroupsRepository groupsRepository;

	@InjectMocks
	private CreateGroupService createGroupService;

	@Mock
	private User mockUser;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		createGroupService = new CreateGroupService(groupsRepository);
		userList.add(mockUser);
		userList.add(mockUser);
	}


	@Test(expected = NullPointerException.class)
	public void givenNullUsersList_whenCreateGroup_ThenThrowNullPointerException() {
		createGroupService.createGroup(null);
	}

	@Test()
	public void givenUserList_whenCreateGroup_ThenGroupContainsThoseUsers() {
		Group group = createGroupService.createGroup(userList);
		assertEquals(group.getUsers().size(), userList.size());
	}

	@Test
	public void givenValidArguments_whenCreateGroup_ThenReturnGroup() {
		Group group = createGroupService.createGroup(userList);
		assertNotNull(group);
	}

	@Test
	public void givenValidArguments_whenCreateGroup_ThenSetGroupBeingCreatedCalledOnce() {
		Group group = createGroupService.createGroup(userList);
		verify(groupsRepository, times(1)).setGroupBeingCreated(group);
	}
}
