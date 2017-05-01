package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.services.CreateGroupService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CreateGroupActionTest {

	@Mock
	private CreateGroupService createGroupService;

	private String groupName = "Group name";
	private CreateGroupAction createGroupAction;

	@Before
	public void setUp() throws Exception {
		createGroupAction = new DefaultCreateGroupAction(createGroupService);
		Mockito.when(createGroupService.createGroup(groupName)).thenReturn(Mockito.mock(Group.class));
	}

	@Test
	public void whenCreateGroupAction_ThenGroupIsNotNull() {
		Group group = createGroupAction.execute(groupName);
		assertNotNull(group);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullUserName_whenCreateUserAction_ThenThrowNullPointerException() {
		createGroupAction.execute(null);
	}
}
