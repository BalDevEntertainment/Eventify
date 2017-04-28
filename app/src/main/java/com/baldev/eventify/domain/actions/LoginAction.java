package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.LoginService;
import com.google.common.base.Preconditions;

import javax.inject.Inject;

public class LoginAction {

	private LoginService loginService;

	@Inject
	public LoginAction(LoginService loginService) {
		Preconditions.checkNotNull(loginService);
		this.loginService = loginService;
	}

	public void execute(User user, final LoginCallback loginCallback) {
		Preconditions.checkNotNull(user);
		Preconditions.checkNotNull(loginCallback);

		loginService.login(user, loginCallback);
	}
}
