package com.baldev.eventify.domain.entities;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GroupTest {

	@Test
	public void givenValidGroupName_WhenNewGroup_ThenGroupHasThatGroupName() {
		String groupName = "Group Name";
		Group group = new Group(groupName);
		assertEquals(group.getName(), groupName);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullGroupName_WhenNewGroup_ThenThrowNullPointerException() {
		new Group(null);
	}
}
