package com.baldev.eventify.domain.actions.groups;


import com.baldev.eventify.domain.actions.users.GetMyUserAction;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.repositories.GroupsRepository;

import java.util.List;

public class DefaultGetMyGroups implements GetMyGroups {

	private GroupsRepository repository;
	private GetMyUserAction getMyUserAction;

	public DefaultGetMyGroups(GroupsRepository repository, GetMyUserAction getMyUserAction) {
		this.repository = repository;
		this.getMyUserAction = getMyUserAction;
	}

	@Override
	public List<Group> execute() {
		return repository.getGroupsByUserId(getMyUserAction.execute().getId());
	}
}
