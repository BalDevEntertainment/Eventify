package com.baldev.eventify.domain.entities;


import com.baldev.eventify.domain.exceptions.InvalidUserNameException;

public class InvalidUser extends User {
	public InvalidUser() throws InvalidUserNameException {
		super(-1, "INVALID USER");
	}
}
