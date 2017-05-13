package com.baldev.eventify.domain.actions.users;

import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.UsersRepository;

import java.util.List;


public class DefaultFindUsersAction implements FindUsersAction {
	private UsersRepository repository;

	public DefaultFindUsersAction(UsersRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<User> execute(int[] userIds) {
		return repository.findUsers(userIds);
	}
}
