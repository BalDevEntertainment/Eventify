package com.baldev.eventify.infrastructure.repositories;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;
import com.baldev.eventify.domain.repositories.GroupsRepository;
import com.google.common.base.Optional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheGroupsRepository implements GroupsRepository {
	protected Map<Integer, ArrayList<Group>> groupsMap = new HashMap<>();
	private static CacheGroupsRepository instance;

	protected CacheGroupsRepository() throws InvalidGroupNameException {
	}

	public static GroupsRepository getInstance() {
		if (instance == null) {
			try {
				instance = new CacheGroupsRepository();
			} catch (InvalidGroupNameException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	@Override
	public List<Group> getGroupsByUserId(int userId) {
		return Optional.fromNullable(groupsMap.get(userId))
				.or(new ArrayList<>());
	}

	@Override
	public Group createGroup(int userId, String groupName, List<User> users) throws InvalidGroupNameException {
		Group group = new Group(groupName, users);
		if(groupsMap.containsKey(userId)){
			groupsMap.get(userId).add(group);
		} else {
			ArrayList<Group> groups = new ArrayList<>();
			groups.add(group);
			groupsMap.put(userId, groups);
		}
		return group;
	}
}
