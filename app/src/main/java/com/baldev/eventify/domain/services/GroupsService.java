package com.baldev.eventify.domain.services;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;
import com.baldev.eventify.domain.repositories.GroupsRepository;

import java.util.List;

import javax.inject.Inject;

public class GroupsService {

	private GroupsRepository groupsRepository;

	@Inject
	public GroupsService(GroupsRepository groupsRepository) {
		this.groupsRepository = groupsRepository;
	}

	public Group createGroup(User user, String groupName, List<User> users) throws InvalidGroupNameException {
		return groupsRepository.createGroup(user, groupName, users);
	}
}
