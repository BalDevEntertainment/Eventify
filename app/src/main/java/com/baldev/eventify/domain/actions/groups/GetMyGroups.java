package com.baldev.eventify.domain.actions.groups;


import com.baldev.eventify.domain.actions.users.GetMyUser;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.repositories.GroupsRepository;

import java.util.List;

public class GetMyGroups {

	private GroupsRepository repository;
	private GetMyUser getMyUser;

	public GetMyGroups(GroupsRepository repository, GetMyUser getMyUser) {
		this.repository = repository;
		this.getMyUser = getMyUser;
	}

	public List<Group> execute() {
		return repository.getGroupsByUser(getMyUser.execute());
	}
}
