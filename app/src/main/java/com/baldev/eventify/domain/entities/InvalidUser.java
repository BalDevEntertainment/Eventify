package com.baldev.eventify.domain.entities;


public class InvalidUser extends User {
	public InvalidUser() {
		super(-1, "INVALID USER");
	}
}
