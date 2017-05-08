package com.baldev.eventify.presentation.createuser;


import com.baldev.eventify.domain.actions.users.SaveUserAction;
import com.baldev.eventify.domain.actions.users.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidUserNameException;
import com.baldev.eventify.presentation.createuser.CreateUserContract.Presenter;
import com.baldev.eventify.presentation.createuser.CreateUserContract.View;
import com.google.common.base.Preconditions;

public class CreateUserPresenter implements Presenter, SaveUserCallback {

	private SaveUserAction saveUserAction;
	private View view;

	public CreateUserPresenter(View view, SaveUserAction saveUserAction) {
		Preconditions.checkNotNull(saveUserAction);
		Preconditions.checkNotNull(view);
		this.saveUserAction = saveUserAction;
		this.view = view;
	}

	@Override
	public void acceptButtonPressed() {
		String userName = view.getUserName();
		try {
			saveUserAction.execute(userName, this);
		} catch (InvalidUserNameException e) {
			showError();
		}
	}

	@Override
	public void onUserSaved() {
		view.startCreateGroupActivity();
	}

	private void showError() {

	}
}
