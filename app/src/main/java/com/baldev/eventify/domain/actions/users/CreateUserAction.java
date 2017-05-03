package com.baldev.eventify.domain.actions.users;

import com.baldev.eventify.domain.entities.User;

public interface CreateUserAction {
	User execute(String userName);
}
