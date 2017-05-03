package com.baldev.eventify.domain.actions.users;

import com.baldev.eventify.domain.entities.User;


public interface SaveUserAction {
	void execute(User user, SaveUserCallback saveUserCallback);
}
