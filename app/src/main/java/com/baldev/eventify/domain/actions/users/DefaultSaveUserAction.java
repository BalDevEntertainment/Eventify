package com.baldev.eventify.domain.actions.users;


import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidUserNameException;
import com.baldev.eventify.domain.services.CreateUserService;
import com.baldev.eventify.domain.services.SaveUserService;
import com.google.common.base.Preconditions;

import javax.inject.Inject;

public class DefaultSaveUserAction implements SaveUserAction {

	private SaveUserService saveUserService;
	private CreateUserService createUserService;

	@Inject
	public DefaultSaveUserAction(CreateUserService createUserService, SaveUserService saveUserService) {
		Preconditions.checkNotNull(createUserService);
		Preconditions.checkNotNull(saveUserService);
		this.createUserService = createUserService;
		this.saveUserService = saveUserService;
	}

	@Override
	public void execute(String username, SaveUserCallback saveUserCallback) throws InvalidUserNameException {
		User user = createUserService.createUser(username);
		saveUserService.saveUser(user, saveUserCallback);
	}
}
