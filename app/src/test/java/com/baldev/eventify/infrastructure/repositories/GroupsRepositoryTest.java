package com.baldev.eventify.infrastructure.repositories;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.repositories.GroupsRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GroupsRepositoryTest {

	@Mock
	private Group group;

	@Test(expected = IllegalStateException.class)
	public void givenGroupBeingCreatedNotSet_whenGetGroupBeingCreated_ThenThrowIllegalStateException() {
		GroupsRepository groupsRepository = CacheGroupsRepository.getInstance();
		groupsRepository.getGroupBeingCreated();
		cleanUp(groupsRepository);
	}

	@Test()
	public void givenGroupBeingCreatedSet_whenGetGroupBeingCreated_ThenReturnGroupBeingCreated() {
		GroupsRepository groupsRepository = CacheGroupsRepository.getInstance();
		groupsRepository.setGroupBeingCreated(group);
		assertEquals(groupsRepository.getGroupBeingCreated(), group);
		cleanUp(groupsRepository);
	}

	private void cleanUp(GroupsRepository groupsRepository) {
		groupsRepository.setGroupBeingCreated(null);
	}
}