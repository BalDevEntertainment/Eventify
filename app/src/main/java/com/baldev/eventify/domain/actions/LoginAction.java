package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.User;

interface LoginAction {
	void execute(User user, LoginCallback loginCallback);
}
