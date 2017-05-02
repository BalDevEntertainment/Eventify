package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.CreateGroupService;

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
	private CreateGroupService createGroupService;

	private CreateGroupAction createGroupAction;
	private List<User> userList = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		createGroupAction = new DefaultCreateGroupAction(createGroupService);
		Mockito.when(createGroupService.createGroup(userList)).thenReturn(Mockito.mock(Group.class));
		userList.add(Mockito.mock(User.class));
	}

	@Test(expected = NullPointerException.class)
	public void givenNullUserList_whenCreateUserAction_ThenThrowNullPointerException() {
		createGroupAction.execute(null);
	}

	@Test
	public void whenCreateGroupAction_ThenGroupIsNotNull() {
		assertNotNull(createGroupAction.execute(userList));
	}
}
