package com.baldev.eventify.domain.entities;


import com.google.common.base.Preconditions;

public class User {
	private String name;

	public User(String name) {
		Preconditions.checkNotNull(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
