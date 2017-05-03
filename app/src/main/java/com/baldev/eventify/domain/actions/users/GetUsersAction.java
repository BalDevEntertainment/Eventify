package com.baldev.eventify.domain.actions.users;


import com.baldev.eventify.domain.repositories.GetUsersCallback;

public interface GetUsersAction {

	void execute(GetUsersCallback callback);
}
