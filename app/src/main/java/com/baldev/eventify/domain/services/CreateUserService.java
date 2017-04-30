package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.entities.User;
import com.google.common.base.Preconditions;

class CreateUserService {
	public User createUser(String userName) {
		Preconditions.checkNotNull(userName);
		return new User(userName);
	}
}
