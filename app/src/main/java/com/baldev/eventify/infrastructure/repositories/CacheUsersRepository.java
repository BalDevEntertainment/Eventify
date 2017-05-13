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

	@Override
	public List<User> findUsers(int[] ids) {
		List<User> users = new ArrayList<>();
		for (int id : ids) {
			User user = getUserById(id);
			if (user != null) {
				users.add(user);
			}
		}
		return users;
	}

	private User getUserById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	private void initializeStubUserList() {
		final Map<Integer, String> names = new HashMap<>();
		names.put(100, "Ariel");
		names.put(101, "Nicolas");
		names.put(102, "Joaquin");
		names.put(103, "Nacho");
		names.put(104, "Matias");
		names.put(105, "Pablo");

		for (int i = 100; i < names.size() + 100; i++) {
			try {
				users.add(new User(i, names.get(i)));
			} catch (InvalidUserNameException e) {
				e.printStackTrace();
			}
		}
	}
}
