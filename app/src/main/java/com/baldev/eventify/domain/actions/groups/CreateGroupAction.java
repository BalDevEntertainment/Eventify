package com.baldev.eventify.domain.actions.groups;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;

import java.util.List;

public interface CreateGroupAction {
	Group execute(User user, String groupName, List<User> users) throws InvalidGroupNameException;
}
