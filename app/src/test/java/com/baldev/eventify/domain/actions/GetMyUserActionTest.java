package com.baldev.eventify.domain.actions;

import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.GetMyUserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetMyUserActionTest {

	@Mock
	GetMyUserService getMyUserService;

	@Before
	public void setUp() throws Exception {
		when(getMyUserService.getMyUser()).thenReturn(mock(User.class));
	}

	@Test
	public void whenGetMyUserAction_ThenUserIsNotNull () {
		GetMyUserAction getMyUserAction = new DefaultGetMyUserAction(getMyUserService);
		assertNotNull(getMyUserAction.execute());
	}
}