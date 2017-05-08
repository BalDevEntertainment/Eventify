package com.baldev.eventify.domain.entities;


import android.support.annotation.NonNull;

import com.baldev.eventify.domain.exceptions.UserNotFoundException;
import com.google.common.base.Preconditions;

import java.util.List;

import javax.inject.Inject;

public class Group {
	private String name;
	private List<User> users;

	@Inject
	public Group(List<User> users) {
		Preconditions.checkNotNull(users);
		this.users = users;
	}

	public String getName() {
		return name;
	}

	@NonNull
	public List<User> getUsers() {
		return users;
	}

	public void addUsers(List<User> userList) {
		this.users.addAll(userList);
	}

	public User getUser(User user) throws UserNotFoundException {
		if (users.contains(user)) {
			for (User u : users) {
				if (u.equals(user)) {
					return u;
				}
			}
		}

		throw new UserNotFoundException();
	}
}
