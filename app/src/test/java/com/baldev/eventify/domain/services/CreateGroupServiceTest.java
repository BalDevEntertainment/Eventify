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

	@Mock
	private GetMyUserService getMyUserService;
	private String groupName = "Group Name";
	private List<User> emptyUserList = new ArrayList<>();
	private List<User> userList = new ArrayList<>();

	@InjectMocks
	private CreateGroupService createGroupService;
	public static final int ONE_USER = 1;

	@Mock
	private User myUser;

	@Mock
	private User mockUser;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		createGroupService = new CreateGroupService(getMyUserService);
		Mockito.when(mockUser.getName()).thenReturn("MockUser");
		Mockito.when(myUser.getName()).thenReturn("MyUser");
		Mockito.when(getMyUserService.getMyUser()).thenReturn(myUser);
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
	public void givenEmptyUserList_whenCreateGroup_ThenAddMyselfAtTheBeginningOfTheList() {
		Group group = createGroupService.createGroup(groupName, emptyUserList);
		assertEquals(group.getUsers().size(), ONE_USER);
		assertEquals(group.getUsers().get(0), getMyUserService.getMyUser());
	}

	@Test()
	public void givenUserList_whenCreateGroup_ThenAddMyselfAtTheBeginningOfTheList() {
		Group group = createGroupService.createGroup(groupName, userList);
		assertEquals(group.getUsers().size(), userList.size() + ONE_USER);
		assertEquals(group.getUsers().get(0).getName(), getMyUserService.getMyUser().getName());
	}

	@Test
	public void givenValidArguments_whenCreateGroup_ThenReturnGroup() {
		Group group = createGroupService.createGroup(groupName, userList);
		assertNotNull(group);
	}
}
