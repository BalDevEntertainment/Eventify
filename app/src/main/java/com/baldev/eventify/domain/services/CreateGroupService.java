package com.baldev.eventify.domain.services;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.google.common.base.Preconditions;

import java.util.List;

import javax.inject.Inject;

public class CreateGroupService {

	@Inject
	public CreateGroupService() {
	}

	public Group createGroup(String groupName, List<User> userList) {
		Preconditions.checkNotNull(groupName);
		Preconditions.checkNotNull(userList);

		return new Group(groupName, userList);
	}
}
