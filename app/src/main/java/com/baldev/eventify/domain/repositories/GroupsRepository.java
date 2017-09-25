package com.baldev.eventify.domain.repositories;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;
import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory.InitializeRepositoriesCallback;

import java.util.List;

public interface GroupsRepository {

	void initialize(InitializeRepositoriesCallback callback);

	List<Group> getGroupsByUser(User user);

	Group createGroup(User user, String groupName, List<User> users) throws InvalidGroupNameException;
}
