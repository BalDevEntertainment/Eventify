package com.baldev.eventify.domain.actions.users;


import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.UsersRepository;

import javax.inject.Inject;

public class DefaultGetMyUserAction implements GetMyUserAction {

	private final UsersRepository usersRepository;

	@Inject
	public DefaultGetMyUserAction(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public User execute() {
		return usersRepository.getMyUser();
	}
}
