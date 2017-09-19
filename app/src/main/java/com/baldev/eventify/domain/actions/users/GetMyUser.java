package com.baldev.eventify.domain.actions.users;


import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.UsersRepository;

import javax.inject.Inject;

public class GetMyUser {

	private final UsersRepository usersRepository;

	@Inject
	public GetMyUser(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public User execute() {
		return usersRepository.getMyUser();
	}
}
