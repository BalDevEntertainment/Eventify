package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.services.CreateGroupService;
import com.google.common.base.Preconditions;

import javax.inject.Inject;

public class DefaultCreateGroupAction implements CreateGroupAction {
	private CreateGroupService createGroupService;

	@Inject
	public DefaultCreateGroupAction(CreateGroupService createGroupService) {
		this.createGroupService = createGroupService;
	}

	@Override
	public Group execute(String groupName) {
		Preconditions.checkNotNull(groupName);
		return createGroupService.createGroup(groupName);
	}

}
