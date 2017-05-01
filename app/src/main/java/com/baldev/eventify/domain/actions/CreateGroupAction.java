package com.baldev.eventify.domain.actions;


import com.baldev.eventify.domain.entities.Group;

public interface CreateGroupAction {
	Group execute(String groupName);
}
