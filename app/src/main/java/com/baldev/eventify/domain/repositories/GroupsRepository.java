package com.baldev.eventify.domain.repositories;

import com.baldev.eventify.domain.entities.Group;

public interface GroupsRepository {
	void setGroupBeingCreated(Group group);

	Group getGroupBeingCreated() throws IllegalStateException;
}
