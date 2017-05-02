package com.baldev.eventify.domain.actions;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;

import java.util.List;

public interface AddUsersToGroupAction {
	void execute(Group group, List<User> userList);
}
