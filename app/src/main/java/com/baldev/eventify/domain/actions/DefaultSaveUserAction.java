package com.baldev.eventify.domain.actions;


import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.SaveUserService;
import com.google.common.base.Preconditions;

import javax.inject.Inject;

public class DefaultSaveUserAction implements SaveUserAction {

	private SaveUserService saveUserService;

	@Inject
	public DefaultSaveUserAction(SaveUserService saveUserService) {
		Preconditions.checkNotNull(saveUserService);
		this.saveUserService = saveUserService;
	}

	@Override
	public void execute(User user, SaveUserCallback saveUserCallback) {
		saveUserService.saveUser(user, saveUserCallback);
	}
}
