package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.AddUsersToGroupService;

import org.junit.Ignore;
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
	private DefaultAddUsersToGroupAction addUsersToGroupAction;
	private List<User> userList = new ArrayList<>();
	private AddUsersToGroupService addUsersToGroupService;

	@Ignore
	@Test
	public void xxx() {
		addUsersToGroupAction.execute(group, userList);
		verify(addUsersToGroupService, times(1)).addUsersToGroup(group, userList);
	}

}