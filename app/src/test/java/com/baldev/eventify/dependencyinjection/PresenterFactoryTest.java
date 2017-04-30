package com.baldev.eventify.dependencyinjection;

import com.baldev.eventify.presentation.createuser.CreateUserActivity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class PresenterFactoryTest {

	@Test
	public void whenProvideCreateUserPresenter_ThenReturnCreateUserPresenter() {
		Assert.assertNotNull(PresenterFactory.provideCreateUserPresenter(Mockito.mock(CreateUserActivity.class)));
	}
}