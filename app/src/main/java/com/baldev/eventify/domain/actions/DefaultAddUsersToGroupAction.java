package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.AddUsersToGroupService;

import java.util.List;


public class DefaultAddUsersToGroupAction implements AddUsersToGroupAction {

	private AddUsersToGroupService addUsersToGroupService;

	public DefaultAddUsersToGroupAction(AddUsersToGroupService addUsersToGroupService) {
		this.addUsersToGroupService = addUsersToGroupService;
	}

	@Override
	public void execute(Group group, List<User> userList) {
		addUsersToGroupService.addUsersToGroup(group, userList);
	}
}
