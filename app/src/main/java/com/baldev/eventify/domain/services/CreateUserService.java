package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidUserNameException;
import com.google.common.base.Preconditions;

public class CreateUserService {
	public User createUser(String userName) throws InvalidUserNameException {
		Preconditions.checkNotNull(userName);
		return new User(1, userName);
	}
}
