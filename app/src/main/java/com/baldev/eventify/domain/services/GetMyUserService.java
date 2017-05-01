package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.UsersRepository;

import javax.inject.Inject;

public class GetMyUserService {
	private UsersRepository usersRepository;

	@Inject
	public GetMyUserService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public User getMyUser() {
		return usersRepository.getMyUser();
	}
}
