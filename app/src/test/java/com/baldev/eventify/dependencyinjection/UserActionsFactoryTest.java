package com.baldev.eventify.dependencyinjection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class UserActionsFactoryTest {

	@Test
	public void whenProvideCreateUserAction_ThenReturnCreateUserAction() {
		assertNotNull(UserActionsFactory.provideCreateUserAction());
	}

	@Test
	public void whenProvideSaveUserAction_ThenReturnSaveUserAction() {
		assertNotNull(UserActionsFactory.provideSaveUserAction());
	}
}