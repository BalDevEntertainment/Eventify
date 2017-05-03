package com.baldev.eventify.presentation.creategroup;

import com.baldev.eventify.domain.actions.groups.CreateGroupAction;
import com.baldev.eventify.domain.actions.users.GetMyUserAction;
import com.baldev.eventify.domain.entities.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateGroupPresenterTest {

	@Mock
	private CreateGroupAction createGroupAction;

	@Mock
	private CreateGroupContract.View view;

	@Mock
	private GetMyUserAction getMyUserAction;

	@Mock
	private User myUser;

	private CreateGroupPresenter createGroupPresenter;

	@Before
	public void setUp() throws Exception {
		when(getMyUserAction.execute()).thenReturn(myUser);
		when(myUser.getId()).thenReturn(1);
		createGroupPresenter = new CreateGroupPresenter(view, createGroupAction, getMyUserAction);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullView_whenNewPresenter_ThenThrowNullPointerException() {
		new CreateGroupPresenter(null, createGroupAction, getMyUserAction);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullCreateGroupAction_whenNewPresenter_ThenThrowNullPointerException() {
		new CreateGroupPresenter(view, null, getMyUserAction);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullGetMyServiceAction_whenNewPresenter_ThenThrowNullPointerException() {
		new CreateGroupPresenter(view, createGroupAction, null);
	}

	@Test()
	public void givenValidParameters_whenNewPresenter_ThenCreatePresenter() {
		assertNotNull(createGroupPresenter);
	}

	@Test()
	public void givenValidParameters_whenNewPresenter_ThenPresenterUserListContainingMyUserAsFirstElement() {
		assertNotNull(createGroupPresenter.getUserList());
		assertEquals(createGroupPresenter.getUserList().get(0).getId(), myUser.getId());
	}
}