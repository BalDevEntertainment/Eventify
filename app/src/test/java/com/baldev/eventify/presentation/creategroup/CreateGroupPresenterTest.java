package com.baldev.eventify.presentation.creategroup;

import android.support.annotation.NonNull;

import com.baldev.eventify.domain.actions.groups.CreateGroup;
import com.baldev.eventify.domain.actions.users.GetMyUser;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateGroupPresenterTest {

	@Mock
	private CreateGroupContract.View view;

	@Mock
	private GetMyUser getMyUser;

	@Mock
	private CreateGroup createGroup;

	@Mock
	private User myUser;
	private CreateGroupPresenter createGroupPresenter;
	private List<User> userEmptyArray = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		when(getMyUser.execute()).thenReturn(myUser);
		when(myUser.getId()).thenReturn("1");
		createGroupPresenter = new CreateGroupPresenter(view, createGroup, getMyUser);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullView_whenNewPresenter_ThenThrowNullPointerException() {
		new CreateGroupPresenter(null, createGroup, getMyUser);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullCreateGroupAction_whenNewPresenter_ThenThrowNullPointerException() {
		new CreateGroupPresenter(view, null, getMyUser);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullGetMyUserAction_whenNewPresenter_ThenThrowNullPointerException() {
		new CreateGroupPresenter(view, createGroup, null);
	}

	@Test()
	public void givenValidParameters_whenNewPresenter_ThenCreatePresenter() {
		assertNotNull(createGroupPresenter);
	}

	@Test()
	public void givenValidParameters_whenNewPresenter_ThenPresenterUserListContainingMyUserAsFirstElement() {
		assertNotNull(createGroupPresenter.users);
		assertEquals(createGroupPresenter.users.get(0).getId(), myUser.getId());
	}

	@Test()
	public void whenAddRemoveMemberButtonPressed_ThenStartUserListActivityForResult() {
		User aUser = givenAUser();
		User anotherUser = givenAnotherUser();
		List<User> users = new ArrayList<>();
		users.add(myUser);
		users.add(aUser);
		users.add(anotherUser);
		createGroupPresenter.users.add(aUser);
		createGroupPresenter.users.add(anotherUser);
		createGroupPresenter.onAddRemoveMemberButtonPressed();
		verify(view, times(1)).startUserListActivityForResult(users);
	}

	@Test()
	public void whenSavePressed_ThenSaveGroupIsCalledOnce() throws InvalidGroupNameException {
		String groupName = "Group Name";
		createGroupPresenter.onSavePressed(groupName);
		List<User> users = new ArrayList<>();
		users.add(myUser);
		verify(createGroup, times(1)).execute(getMyUser.execute(), groupName, users);
	}

	@NonNull
	private User givenAUser() {
		User aUser = Mockito.mock(User.class);
		when(aUser.getId()).thenReturn("10");
		return aUser;
	}

	@NonNull
	private User givenAnotherUser() {
		User anotherUser = Mockito.mock(User.class);
		when(anotherUser.getId()).thenReturn("11");
		return anotherUser;
	}
}