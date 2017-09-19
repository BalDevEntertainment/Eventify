package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.actions.groups.AddUsersToGroup;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.AddUsersToGroupService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddUsersToGroupActionTest {

	@Mock
	private Group group;

	@Mock
	private AddUsersToGroupService addUsersToGroupService;

	private AddUsersToGroup addUsersToGroupAction;
	private List<User> userList = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		addUsersToGroupAction = new AddUsersToGroup(addUsersToGroupService);
	}

	@Test
	public void whenAddUsersToGroupThenDomainServiceIsCalled() {
		addUsersToGroupAction.execute(group, userList);
		verify(addUsersToGroupService, times(1)).addUsersToGroup(group, userList);
	}

	@Test(expected = NullPointerException.class)
	public void whenAddUsersToGroupThenThrowNullPointerException() {
		addUsersToGroupAction.execute(null, userList);
	}
}