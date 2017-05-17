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

	private CreateGroupAction createGroupAction;
	private List<User> userList = new ArrayList<>();
	private String groupName = "Group Name";
	private int myUserId = 1;

	@Before
	public void setUp() throws Exception, InvalidGroupNameException {
		createGroupAction = new DefaultCreateGroupAction(groupsService);
		Mockito.when(groupsService.createGroup(1, groupName, userList)).thenReturn(Mockito.mock(Group.class));
		userList.add(Mockito.mock(User.class));
	}

	@Test(expected = NullPointerException.class)
	public void givenNullUserList_whenCreateUserAction_ThenThrowNullPointerException() throws InvalidGroupNameException {
		createGroupAction.execute(myUserId, groupName, null);
	}

	@Test
	public void whenCreateGroupAction_ThenGroupIsNotNull() throws InvalidGroupNameException {
		assertNotNull(createGroupAction.execute(myUserId, groupName, userList));
	}
}
