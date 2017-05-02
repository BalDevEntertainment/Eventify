package com.baldev.eventify.domain.services;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.GroupsRepository;
import com.google.common.base.Preconditions;

import java.util.List;

import javax.inject.Inject;

public class CreateGroupService {

	private GroupsRepository groupsRepository;

	@Inject
	public CreateGroupService(GroupsRepository groupsRepository) {
		this.groupsRepository = groupsRepository;
	}

	public Group createGroup(String groupName, List<User> userList) {
		Preconditions.checkNotNull(groupName);
		Preconditions.checkNotNull(userList);

		Group group = new Group(groupName, userList);
		groupsRepository.setGroupBeingCreated(group);
		return group;
	}
}
