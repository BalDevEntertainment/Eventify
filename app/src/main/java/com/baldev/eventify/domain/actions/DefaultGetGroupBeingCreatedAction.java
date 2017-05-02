package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.repositories.GroupsRepository;


public class DefaultGetGroupBeingCreatedAction implements GetGroupBeingCreatedAction {
	private GroupsRepository groupsRepository;

	public DefaultGetGroupBeingCreatedAction(GroupsRepository groupsRepository) {
		this.groupsRepository = groupsRepository;
	}

	@Override
	public Group execute() {
		return groupsRepository.getGroupBeingCreated();
	}
}
