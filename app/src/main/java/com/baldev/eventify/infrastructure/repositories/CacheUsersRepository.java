package com.baldev.eventify.infrastructure.repositories;

import com.baldev.eventify.domain.actions.SaveUserCallback;
import com.baldev.eventify.domain.entities.InvalidUser;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.GetUsersCallback;
import com.baldev.eventify.domain.repositories.UsersRepository;
import com.baldev.eventify.infrastructure.StubEntities.StubUser;

import java.util.ArrayList;
import java.util.List;


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
	public void getUsers(GetUsersCallback getUsersCallback) {
		List<User> users = new ArrayList<>();
		createStubUsers(10, users);
		getUsersCallback.onUsersRetrieved(users);
	}

	@Override
	public User getMyUser() {
		return myUser;
	}

	private void createStubUsers(int amount, List<User> users) {
		for (int i = 0; i < amount; i++) {
			users.add(new StubUser());
		}
	}
}
