package com.baldev.eventify.domain.actions.groups;


import com.baldev.eventify.domain.entities.Group;

import java.util.List;

public interface GetMyGroupsAction {
	List<Group> execute();
}
