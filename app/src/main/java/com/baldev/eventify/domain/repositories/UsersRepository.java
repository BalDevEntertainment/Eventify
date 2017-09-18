package com.baldev.eventify.domain.repositories;


import com.baldev.eventify.domain.actions.users.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.entities.UserCreationRequest;

import java.util.List;

public interface UsersRepository {
	User getMyUser();

	void saveUser(UserCreationRequest validUser, SaveUserCallback saveUserCallback);

	void getUsers(GetUsersCallback getUsersCallback);

	List<User> findUsers(String[] ids);
}
