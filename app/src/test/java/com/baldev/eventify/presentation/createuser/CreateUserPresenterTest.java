package com.baldev.eventify.presentation.createuser;


import com.baldev.eventify.domain.actions.CreateUserAction;
import com.baldev.eventify.domain.actions.SaveUserAction;
import com.baldev.eventify.domain.actions.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.isNotNull;
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
	private SaveUserCallback createUserCallback;

	private String userName = "Ari";

	@Before
	public void setUp() throws Exception {
		when(createUserAction.execute(userName)).thenReturn(Mockito.mock(User.class));
	}

	@Test(expected = NullPointerException.class)
	public void givenNullCreateUserAction_whenNewPresenter_ThenThrowNullPointerException() {
		new CreateUserPresenter(null, saveUserAction);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullSaveUserAction_whenNewPresenter_ThenThrowNullPointerException() {
		new CreateUserPresenter(createUserAction, null);
	}

	@Test
	public void whenCreateUser_ThenSaveUserActionIsExecuted() {
		CreateUserPresenter presenter = new CreateUserPresenter(createUserAction, saveUserAction);
		presenter.createUser(userName, createUserCallback);
		verify(saveUserAction, times(1)).execute(isNotNull(User.class), isNotNull(SaveUserCallback.class));
	}
}
