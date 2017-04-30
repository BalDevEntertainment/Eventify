package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.User;
import com.google.common.base.Preconditions;

public class DefaultCreateUserAction implements CreateUserAction {
	@Override
	public User execute(String userName) {
		Preconditions.checkNotNull(userName);
		return new User(userName);
	}
}
