package com.baldev.eventify.dependencyinjection;

import com.baldev.eventify.presentation.creategroup.CreateGroupContract;
import com.baldev.eventify.presentation.createuser.CreateUserContract;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)

public class PresenterFactoryTest {

	@Test
	public void whenProvideCreateUserPresenter_ThenReturnCreateUserPresenter() {
		assertNotNull(PresenterFactory.provideCreateUserPresenter(Mockito.mock(CreateUserContract.View.class)));
	}

	@Test
	public void whenProvideCreateGroupPresenter_ThenReturnCreateGroupPresenter() {
		assertNotNull(PresenterFactory.provideCreateGroupPresenter(Mockito.mock(CreateGroupContract.View.class)));
	}
}