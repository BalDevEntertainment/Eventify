package com.baldev.eventify.presentation.creategroup;

import com.baldev.eventify.domain.actions.CreateGroupAction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreateGroupPresenterTest {

	@Mock
	private CreateGroupAction createGroupAction;

	@Mock
	private CreateGroupContract.View view;

	@Test(expected = NullPointerException.class)
	public void givenNullView_whenNewPresenter_ThenThrowNullPointerException() {
		new CreateGroupPresenter(null, createGroupAction);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullCreateGroupAction_whenNewPresenter_ThenThrowNullPointerException() {
		new CreateGroupPresenter(view, null);
	}
}