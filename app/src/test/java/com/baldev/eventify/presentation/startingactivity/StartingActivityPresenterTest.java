package com.baldev.eventify.presentation.startingactivity;

import com.baldev.eventify.Utils.Called;
import com.baldev.eventify.domain.actions.ApplicationStartCallback;
import com.baldev.eventify.domain.actions.StartApplication;
import com.baldev.eventify.domain.repositories.GroupsRepository;
import com.baldev.eventify.domain.repositories.UsersRepository;
import com.baldev.eventify.presentation.startingactivity.StartingActivityContract.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StartingActivityPresenterTest {

	@Mock
	private UsersRepository usersRepository;
	@Mock
	private GroupsRepository groupsRepository;
	@Mock
	private View view;
	private StartingActivityPresenter startingActivityPresenter;
	private StartApplication startApplication;

	@Before
	public void setup() {
		startApplication = Mockito.mock(StartApplication.class);
		startingActivityPresenter = new StartingActivityPresenter(startApplication);
	}

	@Test()
	public void should_call_start_application_action() {
		whenViewIsCreated(startingActivityPresenter);
		thenActionIsCalled();
	}

	private void whenViewIsCreated(StartingActivityPresenter startingActivityPresenter) {
		startingActivityPresenter.OnViewCreated(view);
	}

	private void thenActionIsCalled() {
		verify(startApplication, times(Called.ONCE)).execute(any(ApplicationStartCallback.class));
	}
}
