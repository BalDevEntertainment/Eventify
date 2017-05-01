package com.baldev.eventify.domain.repositories;

import com.baldev.eventify.domain.entities.User;

import java.util.List;

public interface GetUsersCallback {
	void onUsersRetrieved(List<User> users);
}
