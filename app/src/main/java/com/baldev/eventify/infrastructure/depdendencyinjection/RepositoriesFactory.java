package com.baldev.eventify.infrastructure.depdendencyinjection;


import android.support.annotation.NonNull;

import com.baldev.eventify.domain.repositories.EventsRepository;
import com.baldev.eventify.domain.repositories.GroupsRepository;
import com.baldev.eventify.domain.repositories.UsersRepository;
import com.baldev.eventify.infrastructure.repositories.CacheEventsRepository;
import com.baldev.eventify.infrastructure.repositories.FirebaseEventsRepository;
import com.baldev.eventify.infrastructure.repositories.FirebaseGroupRepository;
import com.baldev.eventify.infrastructure.repositories.FirebaseUserRepository;

public abstract class RepositoriesFactory {

	@NonNull
	public static UsersRepository provideUsersRepository() {
		return FirebaseUserRepository.getInstance();
	}

	@NonNull
	public static GroupsRepository provideGroupsRepository() {
		return FirebaseGroupRepository.getInstance();
	}

	public static EventsRepository provideEventsRepository() {
		return FirebaseEventsRepository.getInstance();
	}

	public interface InitializeRepositoriesCallback {
		void onRepositoryInitialized();

		void onRepositoryInitializationFailed();
	}
}
