package com.baldev.eventify.domain.services;


import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;
import com.baldev.eventify.domain.repositories.GroupsRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GroupsServiceTest {

	private List<User> userList = new ArrayList<>();

	@Mock
	private GroupsRepository groupsRepository;

	@InjectMocks
	private GroupsService groupsService;

	@Mock
	private User mockUser;
	private String groupName = "Group Name";
	private int userId = 1;

	@Before
	public void setUp() throws Exception, InvalidGroupNameException {
		MockitoAnnotations.initMocks(this);
		groupsService = new GroupsService(groupsRepository);
		userList.add(mockUser);
		userList.add(mockUser);
	}

	@Test
	public void whenCreateGroup_ThenCreateGroupInRepositoryIsCalledOnce() throws InvalidGroupNameException {
		groupsService.createGroup(userId, groupName, userList);
		verify(groupsRepository, times(1)).createGroup(userId, groupName, userList);
	}
}
