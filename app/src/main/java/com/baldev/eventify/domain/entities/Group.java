package com.baldev.eventify.domain.entities;


import android.support.annotation.NonNull;

import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;
import com.baldev.eventify.domain.exceptions.UserNotFoundException;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

import javax.inject.Inject;

@IgnoreExtraProperties
public class Group {
	private String name;
	private List<User> users;
	private String groupId;

	public Group() {
		//Constructor for Firebase.
	}

	@Inject
	public Group(String groupId, String groupName, List<User> users) throws InvalidGroupNameException {
		Preconditions.checkNotNull(groupId);
		Preconditions.checkNotNull(users);
		if (Strings.isNullOrEmpty(groupName)) {
			throw new InvalidGroupNameException("Group name can't be empty or null");
		}
		this.groupId = groupId;
		this.name = groupName;
		this.users = users;
	}

	public String getId() {
		return groupId;
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
