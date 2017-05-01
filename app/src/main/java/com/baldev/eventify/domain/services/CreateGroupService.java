package com.baldev.eventify.domain.services;


import android.support.annotation.NonNull;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CreateGroupService {
	private GetMyUserService getMyUserService;

	@Inject
	public CreateGroupService(GetMyUserService getMyUserService) {
		this.getMyUserService = getMyUserService;
	}

	public Group createGroup(String groupName, List<User> userList) {
		Preconditions.checkNotNull(groupName);
		Preconditions.checkNotNull(userList);

		List<User> groupUserList = addMyUserToList(userList);

		return new Group(groupName, groupUserList);
	}

	@NonNull
	private List<User> addMyUserToList(List<User> userList) {
		List<User> groupUserList = new ArrayList<>();
		groupUserList.add(getMyUserService.getMyUser());
		groupUserList.addAll(userList);
		return groupUserList;
	}
}
