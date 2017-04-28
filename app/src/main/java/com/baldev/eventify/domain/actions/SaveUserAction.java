package com.baldev.eventify.domain.actions;


import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.SaveUserService;
import com.google.common.base.Preconditions;

public class SaveUserAction {

	private SaveUserService saveUserService;

	public SaveUserAction(SaveUserService saveUserService) {
		Preconditions.checkNotNull(saveUserService);
		this.saveUserService = saveUserService;
	}

	public void execute(User user, SaveUserCallback saveUserCallback) {
		saveUserService.saveUser(user, saveUserCallback);
	}
}
