package com.baldev.eventify.presentation.userlist;

import com.baldev.eventify.domain.actions.groups.AddUsersToGroupAction;
import com.baldev.eventify.domain.actions.users.GetUsersAction;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.presentation.userlist.UserListContract.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserListPresenterTest {

	@Mock
	private GetUsersAction getUsersAction;
	@Mock
	private View view;
	@Mock
	private AddUsersToGroupAction addUsersToGroupAction;
	@Mock
	private Group group;

	private List<User> userList = new ArrayList<>();

	@InjectMocks
	private UserListPresenter presenter;

	@Before
	public void setUp() throws Exception {
		userList.add(Mockito.mock(User.class));
	}

	@Test(expected = NullPointerException.class)
	public void givenNullView_whenNewPresenter_ThenThrowNullPointerException() {
		new UserListPresenter(null, getUsersAction);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullGetUsersAction_whenNewPresenter_ThenThrowNullPointerException() {
		new UserListPresenter(view, null);
	}
}