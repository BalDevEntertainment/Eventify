package com.baldev.eventify.domain.actions;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;

import java.util.List;

public interface CreateGroupAction {
	Group execute(List<User> users);
}
