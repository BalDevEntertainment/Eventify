package com.baldev.eventify.infrastructure.depdendencyinjection;


import com.baldev.eventify.domain.repositories.UsersRepository;
import com.baldev.eventify.infrastructure.repositories.CacheUsersRepository;

public abstract class RepositoriesFactory {
	public static UsersRepository provideUsersRepository() {
		return CacheUsersRepository.getInstance();
	}
}
