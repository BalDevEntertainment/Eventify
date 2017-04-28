package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.User;

public class DefaultCreateUserAction implements CreateUserAction {
	@Override
	public User execute(String userName) {
		return new User(userName);
	}
}
