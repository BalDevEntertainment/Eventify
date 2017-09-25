package com.baldev.eventify.dependencyinjection;


import android.content.SharedPreferences;

import com.baldev.eventify.domain.actions.StartApplication;
import com.baldev.eventify.domain.actions.events.GetMyEvents;
import com.baldev.eventify.domain.actions.events.SaveEvent;
import com.baldev.eventify.domain.actions.groups.AddUsersToGroup;
import com.baldev.eventify.domain.actions.groups.CreateGroup;
import com.baldev.eventify.domain.actions.groups.GetMyGroups;
import com.baldev.eventify.domain.actions.users.GetMyUser;
import com.baldev.eventify.domain.actions.users.GetUsers;
import com.baldev.eventify.domain.actions.users.SaveUser;
import com.baldev.eventify.domain.repositories.GroupsRepository;
import com.baldev.eventify.domain.repositories.UsersRepository;
import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory;

public class ActionsFactory {

	private GroupsRepository groupsRepository;
	private UsersRepository usersRepository;

	public ActionsFactory(GroupsRepository groupsRepository, UsersRepository usersRepository) {
		this.groupsRepository = groupsRepository;
		this.usersRepository = usersRepository;
	}

	public SaveUser provideSaveUser() {
		return new SaveUser(ServicesFactory.provideCreateUserService(), ServicesFactory.provideSaveUserService());
	}

	public CreateGroup provideCreateGroup() {
		return new CreateGroup(ServicesFactory.provideGroupService());
	}

	public GetMyUser provideGetMyUser() {
		return new GetMyUser(usersRepository);
	}

	public GetUsers provideGetUsers() {
		return new GetUsers(usersRepository);
	}

	public AddUsersToGroup provideAddUsersToGroup() {
		return new AddUsersToGroup(ServicesFactory.provideAddUsersToGroupService());
	}

	public GetMyGroups provideGetMyGroups() {
		return new GetMyGroups(groupsRepository, provideGetMyUser());
	}

	public GetMyEvents provideGetMyEvents() {
		return new GetMyEvents(RepositoriesFactory.provideEventsRepository(), provideGetMyUser());
	}

	public SaveEvent provideSaveEvent() {
		return new SaveEvent(ServicesFactory.provideSaveEvent());
	}

	public StartApplication provideStartApplication(SharedPreferences sharedPreferences) {
		return new StartApplication(sharedPreferences);
	}
}
