package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserActionTest {

	private String userName = "UserName";

	@Test
	public void whenCreateUserAction_ThenUserIsNotNull() {
		CreateUserAction createUserAction = new DefaultCreateUserAction();
		User user = createUserAction.execute(userName);
		assertNotNull(user);
	}
}
