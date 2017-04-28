package com.baldev.eventify.dependencyinjection;


import com.baldev.eventify.domain.actions.CreateUserAction;
import com.baldev.eventify.domain.actions.DefaultCreateUserAction;
import com.baldev.eventify.domain.actions.SaveUserAction;
import com.baldev.eventify.domain.services.SaveUserService;

public abstract class UserActionsFactory {
	public static CreateUserAction createCreateUserAction() {
		return new DefaultCreateUserAction();
	}

	public static SaveUserAction createSaveUserAction() {
		return new SaveUserAction(new SaveUserService());
	}
}
