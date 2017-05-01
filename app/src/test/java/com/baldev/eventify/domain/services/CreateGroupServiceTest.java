package com.baldev.eventify.domain.services;


import com.baldev.eventify.domain.entities.Group;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CreateGroupServiceTest {

	private CreateGroupService createGroupService;
	private String groupName = "Group Name";

	@Before
	public void setUp() throws Exception {
		createGroupService = new CreateGroupService();
	}

	@Test
	public void givenValidUserName_whenCreateUser_ThenUserIsCreated() {
		Group group = createGroupService.createGroup(groupName);
		assertNotNull(group);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullGroupName_whenCreateGroup_ThenThrowNullPointerException() {
		createGroupService.createGroup(null);
	}
}
