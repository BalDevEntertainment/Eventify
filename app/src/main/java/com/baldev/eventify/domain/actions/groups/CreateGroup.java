package com.baldev.eventify.domain.actions.groups;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;
import com.baldev.eventify.domain.services.GroupsService;
import com.google.common.base.Preconditions;

import java.util.List;

public class CreateGroup {
	private GroupsService groupsService;

	public CreateGroup(GroupsService groupsService) {
		this.groupsService = groupsService;
	}

	public Group execute(User user, String groupName, List<User> users) throws InvalidGroupNameException {
		Preconditions.checkNotNull(users);
		return groupsService.createGroup(user, groupName, users);
	}
}
