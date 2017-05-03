package com.baldev.eventify.presentation.createuser;


import com.baldev.eventify.domain.actions.users.CreateUserAction;
import com.baldev.eventify.domain.actions.users.SaveUserAction;
import com.baldev.eventify.domain.actions.users.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserPresenterTest {

	@Mock
	private CreateUserAction createUserAction;
	@Mock
	private SaveUserAction saveUserAction;
	@Mock
	private CreateUserContract.View view;
	@Mock
	private User validUser;

	@InjectMocks
	private CreateUserPresenter presenter;

	private String userName = "UserName";
	private Answer<Void> userSavedAnswer = new UserSavedAnswer();
	private CreateUserPresenter presenterSpy;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(view.getUserName()).thenReturn(userName);
		when(createUserAction.execute(userName)).thenReturn(validUser);
		presenterSpy = Mockito.spy(presenter);
		doAnswer(userSavedAnswer).when(saveUserAction).execute(validUser, presenter);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullView_whenNewPresenter_ThenThrowNullPointerException() {
		new CreateUserPresenter(null, createUserAction, saveUserAction);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullCreateUserAction_whenNewPresenter_ThenThrowNullPointerException() {
		new CreateUserPresenter(view, null, saveUserAction);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullSaveUserAction_whenNewPresenter_ThenThrowNullPointerException() {
		new CreateUserPresenter(view, createUserAction, null);
	}

	@Test
	public void whenSaveUser_ThenSaveUserActionIsExecuted() {
		presenter.acceptButtonPressed();
		verify(presenterSpy, times(1)).onUserSaved();
	}

	private final class UserSavedAnswer implements Answer<Void> {
		@Override
		public Void answer(InvocationOnMock invocation) throws Throwable {
			SaveUserCallback callback = (SaveUserCallback) invocation.getArguments()[1];
			callback.onUserSaved();
			presenterSpy.onUserSaved();
			return null;
		}
	}
}
