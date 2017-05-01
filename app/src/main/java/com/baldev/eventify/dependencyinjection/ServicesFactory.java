package com.baldev.eventify.dependencyinjection;


import android.support.annotation.NonNull;

import com.baldev.eventify.domain.services.CreateGroupService;
import com.baldev.eventify.domain.services.CreateUserService;
import com.baldev.eventify.domain.services.GetMyUserService;
import com.baldev.eventify.domain.services.SaveUserService;
import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory;

public abstract class ServicesFactory {

	@NonNull
	public static CreateUserService provideCreateUserService() {
		return new CreateUserService();
	}

	@NonNull
	public static SaveUserService provideSaveUserService() {
		return new SaveUserService(RepositoriesFactory.provideUsersRepository());
	}

	@NonNull
	public static CreateGroupService provideCreateGroupService() {
		return new CreateGroupService();
	}

	@NonNull
	public static GetMyUserService provideGetMyUserService() {
		return new GetMyUserService(RepositoriesFactory.provideUsersRepository());
	}
}
