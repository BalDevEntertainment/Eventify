package com.baldev.eventify.presentation.createuser;


import com.baldev.eventify.domain.actions.CreateUserAction;
import com.baldev.eventify.domain.actions.SaveUserAction;
import com.baldev.eventify.domain.actions.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;
import com.google.common.base.Preconditions;

public class CreateUserPresenter implements CreateUserContract.Presenter {

	private CreateUserAction createUserAction;
	private SaveUserAction saveUserAction;

	public CreateUserPresenter(CreateUserAction createUserAction, SaveUserAction saveUserAction) {
		Preconditions.checkNotNull(createUserAction);
		Preconditions.checkNotNull(saveUserAction);
		this.createUserAction = createUserAction;
		this.saveUserAction = saveUserAction;
	}

	public void createUser(String userName, SaveUserCallback saveUserCallback) {
		User user = createUserAction.execute(userName);
		saveUserAction.execute(user, saveUserCallback);
	}
}
