package com.baldev.eventify.dependencyinjection;


import android.support.annotation.NonNull;

import com.baldev.eventify.domain.services.CreateUserService;
import com.baldev.eventify.domain.services.SaveUserService;

public abstract class ServicesFactory {

	@NonNull
	public static CreateUserService provideCreateUserService() {
		return new CreateUserService();
	}

	public static SaveUserService provideSaveUserService() {
		return new SaveUserService();
	}
}
