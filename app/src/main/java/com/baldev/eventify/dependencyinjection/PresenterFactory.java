package com.baldev.eventify.dependencyinjection;

import android.support.annotation.NonNull;

import com.baldev.eventify.presentation.creategroup.CreateGroupContract;
import com.baldev.eventify.presentation.creategroup.CreateGroupPresenter;
import com.baldev.eventify.presentation.createuser.CreateUserContract;
import com.baldev.eventify.presentation.createuser.CreateUserPresenter;

public abstract class PresenterFactory {

	@NonNull
	public static CreateUserContract.Presenter provideCreateUserPresenter(CreateUserContract.View view) {
		return new CreateUserPresenter(view, UserActionsFactory.provideCreateUserAction(), UserActionsFactory.provideSaveUserAction());
	}

	public static CreateGroupContract.Presenter provideCreateGroupPresenter(CreateGroupContract.View view) {
		return new CreateGroupPresenter(view, UserActionsFactory.provideCreateGroupAction());
	}
}
