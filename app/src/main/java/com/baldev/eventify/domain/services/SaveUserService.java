package com.baldev.eventify.domain.services;


import com.baldev.eventify.domain.actions.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;

public class SaveUserService {

	public void saveUser(User user, SaveUserCallback saveUserCallback) {
		saveUserCallback.onUserCreated();
	}
}
