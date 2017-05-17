package com.baldev.eventify.dependencyinjection;

import android.support.annotation.NonNull;

import com.baldev.eventify.domain.actions.groups.GetMyGroups;
import com.baldev.eventify.presentation.createevent.CreateEventActivity;
import com.baldev.eventify.presentation.createevent.CreateEventContract;
import com.baldev.eventify.presentation.createevent.CreateEventPresenter;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract;
import com.baldev.eventify.presentation.creategroup.CreateGroupPresenter;
import com.baldev.eventify.presentation.createuser.CreateUserContract;
import com.baldev.eventify.presentation.createuser.CreateUserPresenter;
import com.baldev.eventify.presentation.mainactivity.MainActivityContract;
import com.baldev.eventify.presentation.mainactivity.MainActivityPresenter;
import com.baldev.eventify.presentation.userlist.UserListContract;
import com.baldev.eventify.presentation.userlist.UserListContract.Presenter;
import com.baldev.eventify.presentation.userlist.UserListContract.View;
import com.baldev.eventify.presentation.userlist.UserListPresenter;

import static com.baldev.eventify.dependencyinjection.ActionsFactory.*;

public abstract class PresenterFactory {

	private static GetMyGroups getMyGroups = provideGetMyGroupsAction();

	@NonNull
	public static CreateUserContract.Presenter provideCreateUserPresenter(CreateUserContract.View view) {
		return new CreateUserPresenter(view, provideSaveUserAction());
	}

	@NonNull
	public static CreateGroupContract.Presenter provideCreateGroupPresenter(CreateGroupContract.View view) {
		return new CreateGroupPresenter(view, provideCreateGroupAction(), provideGetMyUserAction(), provideFindUsersAction());
	}

	@NonNull
	public static UserListContract.Presenter provideUserListPresenter(View view, int[] preselectedUserIds) {
		return new UserListPresenter(view, preselectedUserIds, provideGetUsersAction());
	}

	@NonNull
	public static MainActivityContract.Presenter provideMainActivityPresenter(MainActivityContract.View view) {
		return new MainActivityPresenter(view, getMyGroups);
	}

	public static CreateEventContract.Presenter provideCreateEventPresenter(CreateEventContract.View view) {
		return new CreateEventPresenter(view, getMyGroups);
	}
}
