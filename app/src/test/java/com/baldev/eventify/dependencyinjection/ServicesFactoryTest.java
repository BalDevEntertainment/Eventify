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
}
