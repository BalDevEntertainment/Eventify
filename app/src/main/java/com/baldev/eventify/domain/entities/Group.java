package com.baldev.eventify.domain.entities;


import android.support.annotation.NonNull;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class Group {
	private String name;
	private List<User> users;

	@Inject
	public Group(String name, List<User> users) {
		Preconditions.checkNotNull(name);
		Preconditions.checkNotNull(users);
		Preconditions.checkArgument(!users.isEmpty());
		this.name = name;
		this.users = users;
	}

	public String getName() {
		return name;
	}

	@NonNull
	public List<User> getUsers() {
		return users;
	}
}
