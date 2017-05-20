package com.baldev.eventify.dependencyinjection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class ActionsFactoryTest {

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

	@Test
	public void whenProvideGetMyUserAction_ThenReturnGetMyUserAction() {
		assertNotNull(ActionsFactory.provideGetMyUserAction());
	}

	@Test
	public void whenProvideGetUsersAction_ThenReturnGetUsersAction() {
		assertNotNull(ActionsFactory.provideGetUsersAction());
	}

	@Test
	public void whenProvideGetMyGroupsAction_ThenReturnGetMyGroupsAction() {
		assertNotNull(ActionsFactory.provideGetMyGroupsAction());
	}

	@Test
	public void whenProvideFindUsersAction_ThenReturnFindUsersAction() {
		assertNotNull(ActionsFactory.provideFindUsersAction());
	}

	@Test
	public void whenProvideSaveEvent_ThenReturnSaveEvent() {
		assertNotNull(ActionsFactory.provideSaveEvent());
	}
}