package com.baldev.eventify.infrastructure.depdendencyinjection;


import com.baldev.eventify.domain.repositories.UsersRepository;
import com.baldev.eventify.infrastructure.repositories.DefaultUsersRepository;

public abstract class RepositoriesFactory {
	public static UsersRepository provideUsersRepository() {
		return new DefaultUsersRepository();
	}
}
