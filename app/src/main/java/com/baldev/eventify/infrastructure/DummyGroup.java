package com.baldev.eventify.infrastructure;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;

import java.util.List;


public class DummyGroup extends Group {
	public DummyGroup(List<User> users) throws InvalidGroupNameException {
		super("Dummy Group", users);
	}
}
