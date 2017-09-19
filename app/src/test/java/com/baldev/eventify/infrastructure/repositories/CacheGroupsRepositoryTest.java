package com.baldev.eventify.infrastructure.repositories;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;
import com.baldev.eventify.domain.exceptions.UserNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CacheGroupsRepositoryTest {

	@Mock
	private User someUser;
	@Mock
	private Group groupBeingCreated;
	private CacheGroupsRepository groupsRepository;

	@Mock
	private Group group;


	@Test()
	public void whenGetUserGroupsByIdWithoutGroupsThenReturnEmptyList() throws UserNotFoundException {
		buildGroupsRepository();
		assertNotNull(groupsRepository.getGroupsByUser(someUser));
		assertEquals(groupsRepository.getGroupsByUser(someUser).size(), 0);
	}

	@Test()
	public void whenAddGroup_ThenGroupIsAdded() throws InvalidGroupNameException {
		buildGroupsRepository();
		assertEquals(groupsRepository.groupsMap.size(), 0);
		addGroupWithUserId();
		assertEquals(groupsRepository.groupsMap.size(), 1);
		thenGroupMapContainsListWithSize(1);
	}

	@Test()
	public void whenAddTwoGroupsToSameUserThenGroupsAreAdded() throws InvalidGroupNameException {
		buildGroupsRepository();
		addGroupWithUserId();
		addGroupWithUserId();
		thenGroupMapContainsListWithSize(2);
	}

	private void thenGroupMapContainsListWithSize(int size) {
		assertEquals(groupsRepository.groupsMap.get(someUser).size(), size);
	}

	private void addGroupWithUserId() throws InvalidGroupNameException {
		groupsRepository.createGroup(someUser, "Group Name" , new ArrayList<>());
	}

	private void buildGroupsRepository() {
		try {
			groupsRepository = new CacheGroupsRepository();
		} catch (InvalidGroupNameException exception) {

		}
	}
}