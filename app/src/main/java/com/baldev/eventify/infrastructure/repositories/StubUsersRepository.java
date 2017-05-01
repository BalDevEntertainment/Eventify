package com.baldev.eventify.infrastructure.repositories;

import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.UsersRepository;


public class StubUsersRepository implements UsersRepository {
	@Override
	public User getMyUser() {
		return new User(1, "My user");
	}
}
