package com.baldev.eventify.infrastructure.depdendencyinjection;


import android.support.annotation.NonNull;

import com.baldev.eventify.domain.repositories.GroupsRepository;
import com.baldev.eventify.domain.repositories.UsersRepository;
import com.baldev.eventify.infrastructure.repositories.CacheGroupsRepository;
import com.baldev.eventify.infrastructure.repositories.CacheUsersRepository;

public abstract class RepositoriesFactory {

	@NonNull
	public static UsersRepository provideUsersRepository() {
		return CacheUsersRepository.getInstance();
	}

	@NonNull
	public static GroupsRepository provideGroupsRepository() {
		return CacheGroupsRepository.getInstance();
	}
}
