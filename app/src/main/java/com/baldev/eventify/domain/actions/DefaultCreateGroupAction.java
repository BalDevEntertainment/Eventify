package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.CreateGroupService;
import com.google.common.base.Preconditions;

import java.util.List;

import javax.inject.Inject;

public class DefaultCreateGroupAction implements CreateGroupAction {
	private CreateGroupService createGroupService;

	@Inject
	public DefaultCreateGroupAction(CreateGroupService createGroupService) {
		this.createGroupService = createGroupService;
	}

	@Override
	public Group execute(List<User> users) {
		Preconditions.checkNotNull(users);
		return createGroupService.createGroup(users);
	}
}
