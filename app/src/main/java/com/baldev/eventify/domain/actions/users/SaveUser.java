package com.baldev.eventify.domain.actions.users;


import com.baldev.eventify.domain.entities.UserCreationRequest;
import com.baldev.eventify.domain.exceptions.InvalidUserNameException;
import com.baldev.eventify.domain.services.CreateUserService;
import com.baldev.eventify.domain.services.SaveUserService;
import com.google.common.base.Preconditions;

import javax.inject.Inject;

public class SaveUser {

	private SaveUserService saveUserService;
	private CreateUserService createUserService;

	@Inject
	public SaveUser(CreateUserService createUserService, SaveUserService saveUserService) {
		Preconditions.checkNotNull(createUserService);
		Preconditions.checkNotNull(saveUserService);
		this.createUserService = createUserService;
		this.saveUserService = saveUserService;
	}

	public void execute(String username, SaveUserCallback saveUserCallback) throws InvalidUserNameException {
		UserCreationRequest userCreationRequest = createUserService.createUser(username);
		saveUserService.saveUser(userCreationRequest, saveUserCallback);
	}
}
