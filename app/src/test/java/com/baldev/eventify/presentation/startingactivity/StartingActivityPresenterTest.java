package com.baldev.eventify.presentation.startingactivity;

import com.baldev.eventify.Utils.Called;
import com.baldev.eventify.dependencyinjection.FactoryProvider;
import com.baldev.eventify.domain.actions.StartApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StartingActivityPresenterTest {

	private StartingActivityPresenter startingActivityPresenter;
	private StartApplication startApplication;

	@Before
	public void setup() {
		startApplication = FactoryProvider.actionsFactory().startApplication();
		startingActivityPresenter = FactoryProvider.presenterFactory().provideStartingActivityPresenter(startApplication);
	}

	@Test()
	public void should_call_start_application_action() {
		whenViewIsCreated(startingActivityPresenter);
		thenActionIsCalled();
	}

	private void whenViewIsCreated(StartingActivityPresenter startingActivityPresenter) {
		startingActivityPresenter.OnViewCreated();
	}

	private void thenActionIsCalled() {
		verify(startApplication, times(Called.ONCE)).execute();
	}
}
