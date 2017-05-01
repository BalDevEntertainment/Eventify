package com.baldev.eventify.infrastructure.repositories;

import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.UsersRepository;


public class DefaultUsersRepository implements UsersRepository {
	@Override
	public User getMyUser() {
		return null;
	}
}
