package com.baldev.eventify.domain.services;


import com.baldev.eventify.domain.actions.LoginCallback;
import com.baldev.eventify.domain.entities.User;

public class LoginService {
	public void login(User user, LoginCallback callback) {
		callback.onLoginSuccessful();
	}
}
