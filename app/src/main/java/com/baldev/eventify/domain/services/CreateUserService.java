package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.entities.UserCreationRequest;
import com.baldev.eventify.domain.exceptions.InvalidUserNameException;
import com.google.common.base.Preconditions;

public class CreateUserService {
	public UserCreationRequest createUser(String userName) throws InvalidUserNameException {
		Preconditions.checkNotNull(userName);
		return new UserCreationRequest(userName);
	}
}
