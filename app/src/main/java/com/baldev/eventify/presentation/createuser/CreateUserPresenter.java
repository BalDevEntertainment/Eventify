package com.baldev.eventify.presentation.createuser;


import com.baldev.eventify.domain.actions.CreateUserAction;
import com.baldev.eventify.domain.actions.SaveUserAction;
import com.baldev.eventify.domain.actions.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.presentation.createuser.CreateUserContract.Presenter;
import com.baldev.eventify.presentation.createuser.CreateUserContract.View;
import com.google.common.base.Preconditions;

public class CreateUserPresenter implements Presenter, SaveUserCallback {

	private CreateUserAction createUserAction;
	private SaveUserAction saveUserAction;
	private View view;

	public CreateUserPresenter(View view, CreateUserAction createUserAction, SaveUserAction saveUserAction) {
		Preconditions.checkNotNull(createUserAction);
		Preconditions.checkNotNull(saveUserAction);
		Preconditions.checkNotNull(view);
		this.createUserAction = createUserAction;
		this.saveUserAction = saveUserAction;
		this.view = view;
	}

	@Override
	public void acceptButtonPressed() {
		String userName = view.getUserName();
		User user = createUserAction.execute(userName);
		saveUserAction.execute(user, this);
		view.startCreateGroupActivity();
	}

	@Override
	public void onUserCreated() {

	}
}
