package com.baldev.eventify.domain.entities;


import com.baldev.eventify.domain.exceptions.InvalidUserNameException;
import com.google.common.base.Preconditions;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class User implements Serializable {
	private final String name;
	private final String id;

	public User(String id, String name) throws InvalidUserNameException {
		Preconditions.checkNotNull(name);
		if (name.trim().equals("")) {
			throw new InvalidUserNameException();
		}
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			return ((User) obj).getId() == getId();
		}
		return super.equals(obj);
	}
}
