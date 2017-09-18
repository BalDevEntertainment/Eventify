package com.baldev.eventify.domain.repositories;

import com.baldev.eventify.domain.actions.users.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.entities.UserCreationRequest;
import com.baldev.eventify.domain.exceptions.InvalidUserNameException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class FirebaseUserRepository implements UsersRepository {

	private static UsersRepository instance;
	private DatabaseReference database;

	public static UsersRepository getInstance() {
		if (instance == null) {
			instance = new FirebaseUserRepository();
		}
		return instance;
	}

	private FirebaseUserRepository() {
		this.database = FirebaseDatabase.getInstance().getReference();
	}

	@Override
	public User getMyUser() {
		return null;
	}

	@Override
	public void saveUser(UserCreationRequest validUser, SaveUserCallback saveUserCallback) {
		String newUserId = database.child("users").push().getKey();
		try {
			User newUser = new User(newUserId, validUser.getName());
			database.child("users").child(newUser.getId()).setValue(newUser);
		} catch (InvalidUserNameException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getUsers(GetUsersCallback getUsersCallback) {

	}

	@Override
	public List<User> findUsers(String[] ids) {
		return null;
	}
}
