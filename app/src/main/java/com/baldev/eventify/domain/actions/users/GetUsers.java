package com.baldev.eventify.domain.actions.users;


import com.baldev.eventify.domain.repositories.GetUsersCallback;
import com.baldev.eventify.domain.repositories.UsersRepository;

import javax.inject.Inject;

public class GetUsers {
	private UsersRepository usersRepository;

	@Inject
	public GetUsers(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public void execute(GetUsersCallback callback) {
		this.usersRepository.getUsers(callback);
	}
}
