package com.baldev.eventify.presentation.createuser;


import com.baldev.eventify.domain.actions.users.SaveUser;
import com.baldev.eventify.domain.actions.users.SaveUserCallback;
import com.baldev.eventify.domain.exceptions.InvalidUserNameException;
import com.baldev.eventify.presentation.createuser.CreateUserContract.Presenter;
import com.baldev.eventify.presentation.createuser.CreateUserContract.View;
import com.google.common.base.Preconditions;

public class CreateUserPresenter implements Presenter, SaveUserCallback {

	private SaveUser saveUser;
	private View view;

	public CreateUserPresenter(View view, SaveUser saveUser) {
		Preconditions.checkNotNull(saveUser);
		Preconditions.checkNotNull(view);
		this.saveUser = saveUser;
		this.view = view;
	}

	@Override
	public void acceptButtonPressed() {
		String userName = view.getUserName();
		try {
			saveUser.execute(userName, this);
		} catch (InvalidUserNameException e) {
			showError();
		}
	}

	@Override
	public void onUserSaved() {
		view.saveUserIdLocallyOnPhone(); // TODO: 18/09/2017 move to other place
		view.startMainActivity();
	}

	private void showError() {

	}
}
