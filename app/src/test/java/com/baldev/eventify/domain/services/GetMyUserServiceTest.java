package com.baldev.eventify.domain.services;

import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.UsersRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetMyUserServiceTest {

	@Mock
	private User myUser;
	@Mock
	private UsersRepository usersRepository;
	@InjectMocks
	private GetMyUserService getMyUserService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(usersRepository.getMyUser()).thenReturn(myUser);
	}

	@Test
	public void whenGetMyUser_ThenReturnMyUser () {
		assertEquals(getMyUserService.getMyUser(), myUser);
	}

}