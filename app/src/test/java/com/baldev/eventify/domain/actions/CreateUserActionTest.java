package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.actions.users.CreateUserAction;
import com.baldev.eventify.domain.actions.users.DefaultCreateUserAction;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.CreateUserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserActionTest {

	@Mock
	private CreateUserService createUserService;

	private String userName = "UserName";
	private CreateUserAction createUserAction;

	@Before
	public void setUp() throws Exception {
		createUserAction = new DefaultCreateUserAction(createUserService);
		Mockito.when(createUserService.createUser(userName)).thenReturn(Mockito.mock(User.class));
	}

	@Test
	public void whenCreateUserAction_ThenUserIsNotNull() {
		User user = createUserAction.execute(userName);
		assertNotNull(user);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullUserName_whenCreateUserAction_ThenThrowNullPointerException() {
		createUserAction.execute(null);
	}
}
