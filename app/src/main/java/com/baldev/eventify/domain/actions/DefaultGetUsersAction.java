package com.baldev.eventify.domain.actions;


import com.baldev.eventify.domain.repositories.GetUsersCallback;
import com.baldev.eventify.domain.services.GetUsersService;

import javax.inject.Inject;

public class DefaultGetUsersAction implements GetUsersAction {
	private GetUsersService getUsersService;

	@Inject
	public DefaultGetUsersAction(GetUsersService getUsersService) {
		this.getUsersService = getUsersService;
	}

	@Override
	public void execute(GetUsersCallback callback) {
		this.getUsersService.getUsers(callback);
	}
}
