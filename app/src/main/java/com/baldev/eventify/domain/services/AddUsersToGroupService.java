package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;

import java.util.List;

public class AddUsersToGroupService {
	public void addUsersToGroup(Group group, List<User> userList) {
		group.addUsers(userList);
	}
}
