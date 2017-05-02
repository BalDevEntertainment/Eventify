package com.baldev.eventify.dependencyinjection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class ActionsFactoryTest {

	@Test
	public void whenProvideCreateUserAction_ThenReturnCreateUserAction() {
		assertNotNull(ActionsFactory.provideCreateUserAction());
	}

	@Test
	public void whenProvideSaveUserAction_ThenReturnSaveUserAction() {
		assertNotNull(ActionsFactory.provideSaveUserAction());
	}

	@Test
	public void whenProvideCreateGroupAction_ThenReturnCreateGroupAction() {
		assertNotNull(ActionsFactory.provideCreateGroupAction());
	}

	@Test
	public void whenProvideAddUsersToGroupAction_ThenReturnCreateGroupAction() {
		assertNotNull(ActionsFactory.provideAddUsersToGroupAction());
	}
}