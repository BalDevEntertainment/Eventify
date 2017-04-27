package com.baldev.eventify.domain.services;


import com.baldev.eventify.domain.actions.LoginCallback;
import com.baldev.eventify.domain.entities.User;

public class LoginService {
	public void execute(User user, LoginCallback callback) {
		callback.onLoginSuccessful();
	}
}
