package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserActionTest {

	private String userName = "UserName";
	private CreateUserAction createUserAction;

	@Before
	public void setUp() throws Exception {
		createUserAction = new DefaultCreateUserAction();
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
