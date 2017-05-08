package com.baldev.eventify.infrastructure.repositories;

import com.baldev.eventify.domain.actions.users.SaveUserCallback;
import com.baldev.eventify.domain.entities.InvalidUser;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidUserNameException;
import com.baldev.eventify.domain.repositories.GetUsersCallback;
import com.baldev.eventify.domain.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CacheUsersRepository implements UsersRepository {

	private static CacheUsersRepository instance;
	private User myUser;
	private List<User> users = new ArrayList<>();

	private CacheUsersRepository() {
		initializeStubUserList();
		try {
			myUser = new InvalidUser();
		} catch (InvalidUserNameException e) {
			e.printStackTrace();
		}
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
		saveUserCallback.onUserSaved();
	}

	@Override
	public void getUsers(GetUsersCallback getUsersCallback) {
		getUsersCallback.onUsersRetrieved(users);
	}

	@Override
	public User getMyUser() {
		return myUser;
	}

	private void initializeStubUserList() {
		final Map<Integer, String> names = new HashMap<>();
		names.put(0, "Ariel");
		names.put(1, "Nicolas");
		names.put(2, "Joaquin");
		names.put(3, "Nacho");
		names.put(4, "Matias");
		names.put(5, "Pablo");

		for (int i = 0; i < names.size(); i++) {
			try {
				users.add(new User(i, names.get(i)));
			} catch (InvalidUserNameException e) {
				e.printStackTrace();
			}
		}
	}
}
