package com.baldev.eventify.domain.actions.users;

import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidUserNameException;


public interface SaveUserAction {
	void execute(String user, SaveUserCallback saveUserCallback) throws InvalidUserNameException;
}
