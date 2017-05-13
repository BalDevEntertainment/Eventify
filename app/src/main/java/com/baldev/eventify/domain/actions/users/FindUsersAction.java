package com.baldev.eventify.domain.actions.users;


import com.baldev.eventify.domain.entities.User;

import java.util.List;

public interface FindUsersAction {
	List<User> execute(int[] userIds);
}
