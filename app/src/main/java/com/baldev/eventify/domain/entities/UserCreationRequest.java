package com.baldev.eventify.domain.entities;


import com.baldev.eventify.domain.exceptions.InvalidUserNameException;
import com.google.common.base.Preconditions;

public class UserCreationRequest {
	private final String name;

	public UserCreationRequest(String name) throws InvalidUserNameException {
		Preconditions.checkNotNull(name);
		if (name.trim().equals("")) {
			throw new InvalidUserNameException();
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
