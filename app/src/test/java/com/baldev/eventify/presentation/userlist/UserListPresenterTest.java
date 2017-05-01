package com.baldev.eventify.presentation.userlist;

import com.baldev.eventify.domain.actions.GetUsersAction;
import com.baldev.eventify.presentation.userlist.UserListContract.View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserListPresenterTest {

	@Mock
	private GetUsersAction getUsersAction;
	@Mock
	private View view;

	@Test(expected = NullPointerException.class)
	public void givenNullView_whenNewPresenter_ThenThrowNullPointerException() {
		new UserListPresenter(null, getUsersAction);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullGetUsersAction_whenNewPresenter_ThenThrowNullPointerException() {
		new UserListPresenter(view, null);
	}
}