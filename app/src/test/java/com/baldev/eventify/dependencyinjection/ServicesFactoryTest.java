package com.baldev.eventify.dependencyinjection;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ServicesFactoryTest {

	@Test
	public void whenProvideCreateUserService_ThenReturnCreateUserService() {
		assertNotNull(ServicesFactory.provideCreateUserService());
	}

	@Test
	public void whenProvideSaveUserService_ThenReturnSaveUserService() {
		assertNotNull(ServicesFactory.provideSaveUserService());
	}

	@Test
	public void whenProvideSaveEventService_ThenReturnSaveEventService() {
		assertNotNull(ServicesFactory.provideSaveEvent());
	}

	@Test
	public void whenProvideCreateEventService_ThenReturnCreateEventService() {
		assertNotNull(ServicesFactory.provideCreateEventService());
	}
}
