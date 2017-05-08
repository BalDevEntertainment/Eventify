package com.baldev.eventify.dependencyinjection;

import android.support.annotation.NonNull;

import com.baldev.eventify.presentation.creategroup.CreateGroupContract;
import com.baldev.eventify.presentation.creategroup.CreateGroupPresenter;
import com.baldev.eventify.presentation.createuser.CreateUserContract;
import com.baldev.eventify.presentation.createuser.CreateUserPresenter;
import com.baldev.eventify.presentation.userlist.UserListContract;
import com.baldev.eventify.presentation.userlist.UserListContract.Presenter;
import com.baldev.eventify.presentation.userlist.UserListPresenter;

import static com.baldev.eventify.dependencyinjection.ActionsFactory.*;

public abstract class PresenterFactory {

	@NonNull
	public static CreateUserContract.Presenter provideCreateUserPresenter(CreateUserContract.View view) {
		return new CreateUserPresenter(view, provideSaveUserAction());
	}

	@NonNull
	public static CreateGroupContract.Presenter provideCreateGroupPresenter(CreateGroupContract.View view) {
		return new CreateGroupPresenter(view, provideCreateGroupAction(), provideGetMyUserAction());
	}

	@NonNull
	public static Presenter provideUserListPresenter(UserListContract.View view) {
		return new UserListPresenter(view, provideGetUsersAction(), provideAddUsersToGroupAction(), provideGetGroupBeingCreated());
	}
}
