package com.baldev.eventify.infrastructure.repositories;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.GroupsRepository;
import com.baldev.eventify.infrastructure.DummyGroup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GroupsRepositoryTest {

	@Mock
	private Group group;
	private GroupsRepository groupsRepository = CacheGroupsRepository.getInstance();

	@Test(expected = NullPointerException.class)
	public void givenNullGroupBeingCreated_whenSetGroupBeingCreated_ThenThrowNullPointerException() {
		groupsRepository.setGroupBeingCreated(null);
		cleanUp(groupsRepository);
	}

	@Test()
	public void givenGroupBeingCreatedSet_whenGetGroupBeingCreated_ThenReturnGroupBeingCreated() {
		groupsRepository.setGroupBeingCreated(group);
		assertEquals(groupsRepository.getGroupBeingCreated(), group);
		cleanUp(groupsRepository);
	}

	private void cleanUp(GroupsRepository groupsRepository) {
		groupsRepository.setGroupBeingCreated(new DummyGroup(new ArrayList<>()));
	}
}