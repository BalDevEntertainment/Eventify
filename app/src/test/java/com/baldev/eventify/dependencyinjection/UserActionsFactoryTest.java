package com.baldev.eventify.dependencyinjection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class UserActionsFactoryTest {

	@Test
	public void whenCreateCreateUserAction_ThenReturnCreateUserAction() {
		assertNotNull(UserActionsFactory.createCreateUserAction());
	}

	@Test
	public void whenCreateSaveUserAction_ThenReturnSaveUserAction() {
		assertNotNull(UserActionsFactory.createSaveUserAction());
	}
}