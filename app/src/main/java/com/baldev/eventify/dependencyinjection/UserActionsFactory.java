package com.baldev.eventify.dependencyinjection;


import com.baldev.eventify.domain.actions.CreateUserAction;
import com.baldev.eventify.domain.actions.DefaultCreateUserAction;
import com.baldev.eventify.domain.actions.DefaultSaveUserAction;
import com.baldev.eventify.domain.actions.SaveUserAction;

public abstract class UserActionsFactory {
	public static CreateUserAction provideCreateUserAction() {
		return new DefaultCreateUserAction(ServicesFactory.provideCreateUserService());
	}

	public static SaveUserAction provideSaveUserAction() {
		return new DefaultSaveUserAction(ServicesFactory.provideSaveUserService());
	}
}
