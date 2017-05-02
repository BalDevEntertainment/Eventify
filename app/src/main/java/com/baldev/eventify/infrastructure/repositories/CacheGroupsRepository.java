package com.baldev.eventify.infrastructure.repositories;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.repositories.GroupsRepository;

public class CacheGroupsRepository implements GroupsRepository {
	private static CacheGroupsRepository instance;
	private Group groupBeingCreated;

	private CacheGroupsRepository() {
	}

	public static GroupsRepository getInstance() {
		if (instance == null) {
			instance = new CacheGroupsRepository();
		}
		return instance;
	}

	@Override
	public void setGroupBeingCreated(Group group) {
		this.groupBeingCreated = group;
	}

	@Override
	public Group getGroupBeingCreated() throws IllegalStateException {
		if(this.groupBeingCreated == null){
			throw new IllegalStateException("Can't call getGroupBeingCreated without setting the group first");
		}

		return this.groupBeingCreated;
	}

}
