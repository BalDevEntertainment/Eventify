package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.User;

public interface CreateUserAction {
	User execute(String userName);
}
