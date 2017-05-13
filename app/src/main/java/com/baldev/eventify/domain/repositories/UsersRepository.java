package com.baldev.eventify.domain.repositories;


import com.baldev.eventify.domain.actions.users.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;

import java.util.List;

public interface UsersRepository {
	User getMyUser();

	void saveUser(User validUser, SaveUserCallback saveUserCallback);

	void getUsers(GetUsersCallback getUsersCallback);

	List<User> findUsers(int[] ids);
}
