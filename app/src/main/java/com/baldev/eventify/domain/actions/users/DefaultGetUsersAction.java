package com.baldev.eventify.domain.actions.users;


import com.baldev.eventify.domain.repositories.GetUsersCallback;
import com.baldev.eventify.domain.repositories.UsersRepository;

import javax.inject.Inject;

public class DefaultGetUsersAction implements GetUsersAction {
	private UsersRepository usersRepository;

	@Inject
	public DefaultGetUsersAction(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public void execute(GetUsersCallback callback) {
		this.usersRepository.getUsers(callback);
	}
}
