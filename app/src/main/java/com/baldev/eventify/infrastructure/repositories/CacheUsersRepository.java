package com.baldev.eventify.infrastructure.repositories;

import android.util.SparseArray;

import com.baldev.eventify.domain.actions.SaveUserCallback;
import com.baldev.eventify.domain.entities.InvalidUser;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.GetUsersCallback;
import com.baldev.eventify.domain.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CacheUsersRepository implements UsersRepository {

	private static CacheUsersRepository instance;
	private User myUser = new InvalidUser();
	private List<User> users = new ArrayList<>();

	private CacheUsersRepository() {
		initializeStubUserList();
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
			users.add(new User(i, names.get(i)));
		}
	}
}
