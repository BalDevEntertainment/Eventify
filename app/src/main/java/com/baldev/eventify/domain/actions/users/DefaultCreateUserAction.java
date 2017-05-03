package com.baldev.eventify.domain.actions.users;

import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.CreateUserService;
import com.google.common.base.Preconditions;

import javax.inject.Inject;

public class DefaultCreateUserAction implements CreateUserAction {
	private CreateUserService createUserService;

	@Inject
	public DefaultCreateUserAction(CreateUserService createUserService) {
		this.createUserService = createUserService;
	}

	@Override
	public User execute(String userName) {
		Preconditions.checkNotNull(userName);
		return createUserService.createUser(userName);
	}
}
