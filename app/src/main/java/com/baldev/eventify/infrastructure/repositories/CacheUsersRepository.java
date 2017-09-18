package com.baldev.eventify.infrastructure.repositories;

import com.baldev.eventify.domain.actions.users.SaveUserCallback;
import com.baldev.eventify.domain.entities.InvalidUser;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.entities.UserCreationRequest;
import com.baldev.eventify.domain.exceptions.InvalidUserNameException;
import com.baldev.eventify.domain.repositories.GetUsersCallback;
import com.baldev.eventify.domain.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;


public class CacheUsersRepository implements UsersRepository {

	private static CacheUsersRepository instance;
	private User myUser;
	private List<User> users = new ArrayList<>();

	private CacheUsersRepository() {
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
	public void saveUser(UserCreationRequest userCreationRequest, SaveUserCallback saveUserCallback) {
		try {
			this.myUser = new User("NewId", userCreationRequest.getName());
		} catch (InvalidUserNameException e) {
			e.printStackTrace();
		}
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
	public List<User> findUsers(String[] ids) {
		List<User> users = new ArrayList<>();
		for (String id : ids) {
			User user = getUserById(id);
			if (user != null) {
				users.add(user);
			}
		}
		return users;
	}

	private User getUserById(String id) {
		for (User user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
}
