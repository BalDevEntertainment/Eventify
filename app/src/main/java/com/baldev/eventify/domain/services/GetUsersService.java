package com.baldev.eventify.domain.services;


import com.baldev.eventify.domain.repositories.GetUsersCallback;
import com.baldev.eventify.domain.repositories.UsersRepository;

import javax.inject.Inject;

class GetUsersService {
	private UsersRepository usersRepository;

	@Inject
	public GetUsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public void getUsers(GetUsersCallback getUsersCallback) {
		usersRepository.getUsers(getUsersCallback);
	}
}
