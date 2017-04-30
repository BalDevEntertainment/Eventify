package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.User;


public interface SaveUserAction {
	void execute(User user, SaveUserCallback saveUserCallback);
}
