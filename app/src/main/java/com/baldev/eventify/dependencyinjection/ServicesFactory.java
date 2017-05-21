package com.baldev.eventify.dependencyinjection;


import android.support.annotation.NonNull;

import com.baldev.eventify.domain.repositories.UsersRepository;
import com.baldev.eventify.domain.services.AddUsersToGroupService;
import com.baldev.eventify.domain.services.CreateEventService;
import com.baldev.eventify.domain.services.CreateUserService;
import com.baldev.eventify.domain.services.GroupsService;
import com.baldev.eventify.domain.services.SaveEventService;
import com.baldev.eventify.domain.services.SaveUserService;
import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory;

public abstract class ServicesFactory {

	private static UsersRepository usersRepository = RepositoriesFactory.provideUsersRepository();

	@NonNull
	public static CreateUserService provideCreateUserService() {
		return new CreateUserService();
	}

	@NonNull
	public static SaveUserService provideSaveUserService() {
		return new SaveUserService(usersRepository);
	}

	@NonNull
	public static GroupsService provideGroupService() {
		return new GroupsService(RepositoriesFactory.provideGroupsRepository());
	}

	public static AddUsersToGroupService provideAddUsersToGroupService() {
		return new AddUsersToGroupService();
	}

	public static SaveEventService provideSaveEvent() {
		return new SaveEventService(RepositoriesFactory.provideEventsRepository());
	}

	public static CreateEventService provideCreateEventService() {
		return new CreateEventService();
	}
}
