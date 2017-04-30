package com.baldev.eventify.dependencyinjection;

import android.support.annotation.NonNull;

import com.baldev.eventify.presentation.createuser.CreateUserContract.View;
import com.baldev.eventify.presentation.createuser.CreateUserPresenter;

public abstract class PresenterFactory {

	@NonNull
	public static CreateUserPresenter provideCreateUserPresenter(View view) {
		return new CreateUserPresenter(view, UserActionsFactory.createCreateUserAction(), UserActionsFactory.createSaveUserAction());
	}
}
