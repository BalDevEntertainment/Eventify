package com.baldev.eventify.domain.repositories;


import com.baldev.eventify.domain.actions.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;

public interface UsersRepository {
	User getMyUser();

	void saveUser(User validUser, SaveUserCallback saveUserCallback);

	void getUsers(GetUsersCallback getUsersCallback);
}
