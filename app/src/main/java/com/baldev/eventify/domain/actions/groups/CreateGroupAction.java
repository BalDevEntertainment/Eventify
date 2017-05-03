package com.baldev.eventify.domain.actions.groups;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;

import java.util.List;

public interface CreateGroupAction {
	Group execute(List<User> users);
}
