package com.baldev.eventify.domain.actions.groups;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.AddUsersToGroupService;
import com.google.common.base.Preconditions;

import java.util.List;


public class AddUsersToGroup {

	private AddUsersToGroupService addUsersToGroupService;

	public AddUsersToGroup(AddUsersToGroupService addUsersToGroupService) {
		this.addUsersToGroupService = addUsersToGroupService;
	}

	public void execute(Group group, List<User> userList) {
		Preconditions.checkNotNull(group);
		addUsersToGroupService.addUsersToGroup(group, userList);
	}
}
