package com.baldev.eventify.domain.actions.groups;

import com.baldev.eventify.domain.actions.users.GetMyUser;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.GroupsRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetMyGroupsTest {

	@Mock
	private GroupsRepository groupsRepository;
	@Mock
	private GetMyUser getMyUser;

	@Test()
	public void whenExecuteThenReturnGroups(){
		User user = Mockito.mock(User.class);
		when(getMyUser.execute()).thenReturn(user);
		when(user.getId()).thenReturn("1");
		new GetMyGroups(groupsRepository, getMyUser).execute();
		verify(groupsRepository, times(1)).getGroupsByUser(user);
	}
}