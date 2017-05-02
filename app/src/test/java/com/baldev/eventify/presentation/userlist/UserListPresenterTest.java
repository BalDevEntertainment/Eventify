package com.baldev.eventify.presentation.userlist;

import com.baldev.eventify.domain.actions.AddUsersToGroupAction;
import com.baldev.eventify.domain.actions.GetGroupBeingCreatedAction;
import com.baldev.eventify.domain.actions.GetUsersAction;
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

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
	@Mock
	private GetGroupBeingCreatedAction getGroupBeingCreatedAction;

	private List<User> userList = new ArrayList<>();

	@InjectMocks
	private UserListPresenter presenter;

	@Before
	public void setUp() throws Exception {
		userList.add(Mockito.mock(User.class));
		when(getGroupBeingCreatedAction.execute()).thenReturn(group);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullView_whenNewPresenter_ThenThrowNullPointerException() {
		new UserListPresenter(null, getUsersAction, addUsersToGroupAction, getGroupBeingCreatedAction);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullGetUsersAction_whenNewPresenter_ThenThrowNullPointerException() {
		new UserListPresenter(view, null, addUsersToGroupAction, getGroupBeingCreatedAction);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullAddUsersToGroupAction_whenNewPresenter_ThenThrowNullPointerException() {
		new UserListPresenter(view, getUsersAction, null, getGroupBeingCreatedAction);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullGetUserBeingCreatedAction_whenNewPresenter_ThenThrowNullPointerException() {
		new UserListPresenter(view, getUsersAction, addUsersToGroupAction, null);
	}

	@Test()
	public void whenOnUsersRetrieved_ThenAddUsersToGroupActionIsExecuted() {
		presenter = new UserListPresenter(view, getUsersAction, addUsersToGroupAction, getGroupBeingCreatedAction);
		presenter.onUsersRetrieved(userList);
		verify(addUsersToGroupAction, times(1)).execute(group, userList);
	}
}