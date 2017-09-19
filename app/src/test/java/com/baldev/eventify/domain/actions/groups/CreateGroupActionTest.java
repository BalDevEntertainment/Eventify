package com.baldev.eventify.domain.actions.groups;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;
import com.baldev.eventify.domain.services.GroupsService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CreateGroupActionTest {

	@Mock
	private GroupsService groupsService;

	@Mock
	private User user;

	@Mock
	private User myUser;

	private CreateGroup createGroup;
	private List<User> userList = new ArrayList<>();
	private String groupName = "Group Name";

	@Before
	public void setUp() throws Exception, InvalidGroupNameException {
		createGroup = new CreateGroup(groupsService);
		Mockito.when(groupsService.createGroup(user, groupName, userList)).thenReturn(Mockito.mock(Group.class));
		userList.add(Mockito.mock(User.class));
	}

	@Test(expected = NullPointerException.class)
	public void givenNullUserList_whenCreateUserAction_ThenThrowNullPointerException() throws InvalidGroupNameException {
		createGroup.execute(myUser, groupName, null);
	}

	@Test
	public void whenCreateGroupAction_ThenGroupIsNotNull() throws InvalidGroupNameException {
		assertNotNull(createGroup.execute(user, groupName, userList));
	}
}
