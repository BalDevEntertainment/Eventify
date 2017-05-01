package com.baldev.eventify.infrastructure.repositories;

import com.baldev.eventify.domain.actions.SaveUserCallback;
import com.baldev.eventify.domain.entities.InvalidUser;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.UsersRepository;


public class CacheUsersRepository implements UsersRepository {

	private static CacheUsersRepository instance;
	private User myUser = new InvalidUser();

	private CacheUsersRepository() {
	}

	public static UsersRepository getInstance() {
		if (instance == null) {
			instance = new CacheUsersRepository();
		}
		return instance;
	}

	@Override
	public void saveUser(User user, SaveUserCallback saveUserCallback) {
		this.myUser = user;
	}

	@Override
	public User getMyUser() {
		return myUser;
	}
}
