package com.baldev.eventify.dependencyinjection;

import android.support.annotation.NonNull;

import com.baldev.eventify.domain.actions.StartApplication;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.presentation.createevent.CreateEventContract;
import com.baldev.eventify.presentation.createevent.CreateEventPresenter;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract;
import com.baldev.eventify.presentation.creategroup.CreateGroupPresenter;
import com.baldev.eventify.presentation.createuser.CreateUserContract;
import com.baldev.eventify.presentation.createuser.CreateUserPresenter;
import com.baldev.eventify.presentation.mainactivity.MainActivityContract;
import com.baldev.eventify.presentation.mainactivity.MainActivityPresenter;
import com.baldev.eventify.presentation.mainactivity.events.EventsFragment;
import com.baldev.eventify.presentation.mainactivity.events.EventsFragmentPresenter;
import com.baldev.eventify.presentation.mainactivity.groups.GroupsFragment;
import com.baldev.eventify.presentation.mainactivity.groups.GroupsFragmentPresenter;
import com.baldev.eventify.presentation.startingactivity.StartingActivityPresenter;
import com.baldev.eventify.presentation.userlist.UserListContract;
import com.baldev.eventify.presentation.userlist.UserListContract.View;
import com.baldev.eventify.presentation.userlist.UserListPresenter;

import java.util.List;

public class PresenterFactory {

	private final ActionsFactory actionsFactory;

	public PresenterFactory(ActionsFactory actionsFactory) {
		this.actionsFactory = actionsFactory;
	}

	@NonNull
	public CreateUserContract.Presenter provideCreateUserPresenter(CreateUserContract.View view) {
		return new CreateUserPresenter(view, actionsFactory.provideSaveUser());
	}

	@NonNull
	public CreateGroupContract.Presenter provideCreateGroupPresenter(CreateGroupContract.View view) {
		return new CreateGroupPresenter(view, actionsFactory.provideCreateGroup(), actionsFactory.provideGetMyUser());
	}

	@NonNull
	public UserListContract.Presenter provideUserListPresenter(View view, List<User> preselectedUsers) {
		return new UserListPresenter(view, preselectedUsers, actionsFactory.provideGetUsers());
	}

	@NonNull
	public MainActivityContract.Presenter provideMainActivityPresenter(MainActivityContract.View view) {
		return new MainActivityPresenter(view, actionsFactory.provideGetMyGroups());
	}

	public CreateEventContract.Presenter provideCreateEventPresenter(CreateEventContract.View view) {
		return new CreateEventPresenter(view, actionsFactory.provideGetMyGroups(), actionsFactory.provideSaveEvent());
	}

	public GroupsFragmentPresenter provideGroupsFragmentPresenter(GroupsFragment view) {
		return new GroupsFragmentPresenter(view, actionsFactory.provideGetMyGroups());
	}

	public EventsFragmentPresenter provideEventsFragmentPresenter(EventsFragment view) {
		return new EventsFragmentPresenter(view, actionsFactory.provideGetMyEvents());
	}

	public StartingActivityPresenter provideStartingActivityPresenter(StartApplication startApplication) {
		return new StartingActivityPresenter(startApplication);
	}
}
