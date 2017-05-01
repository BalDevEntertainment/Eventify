package com.baldev.eventify.domain.services;


import com.baldev.eventify.domain.entities.Group;
import com.google.common.base.Preconditions;

public class CreateGroupService {
	public Group createGroup(String groupName) {
		Preconditions.checkNotNull(groupName);
		return new Group();
	}
}
