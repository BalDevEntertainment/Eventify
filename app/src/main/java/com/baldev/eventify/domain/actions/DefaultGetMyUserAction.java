package com.baldev.eventify.domain.actions;


import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.GetMyUserService;

import javax.inject.Inject;

public class DefaultGetMyUserAction implements GetMyUserAction {

	private GetMyUserService getMyUserService;

	@Inject
	public DefaultGetMyUserAction(GetMyUserService getMyUserService) {
		this.getMyUserService = getMyUserService;
	}

	@Override
	public User execute() {
		return getMyUserService.getMyUser();
	}
}
