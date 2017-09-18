package com.baldev.eventify.domain.repositories;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;

import java.util.List;

public interface GroupsRepository {

	List<Group> getGroupsByUser(User user);

	Group createGroup(User user, String groupName, List<User> users) throws InvalidGroupNameException;
}
