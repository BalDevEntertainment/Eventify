package com.baldev.eventify.infrastructure.repositories;


import android.support.annotation.NonNull;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.repositories.GroupsRepository;
import com.baldev.eventify.infrastructure.DummyGroup;
import com.google.common.base.Preconditions;

import java.util.ArrayList;

public class CacheGroupsRepository implements GroupsRepository {
	private static CacheGroupsRepository instance;
	private Group groupBeingCreated = new DummyGroup(new ArrayList<>());

	private CacheGroupsRepository() {
	}

	public static GroupsRepository getInstance() {
		if (instance == null) {
			instance = new CacheGroupsRepository();
		}
		return instance;
	}

	@Override
	public void setGroupBeingCreated(@NonNull Group group) {
		Preconditions.checkNotNull(group);
		this.groupBeingCreated = group;
	}

	@Override
	public Group getGroupBeingCreated(){
		return this.groupBeingCreated;
	}
}
