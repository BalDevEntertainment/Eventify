package com.baldev.eventify.domain.entities;


import com.google.common.base.Preconditions;

public class User {
	private final String name;
	private final int id;

	public User(int id, String name) {
		Preconditions.checkNotNull(name);
		Preconditions.checkArgument(id > 0);
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}
