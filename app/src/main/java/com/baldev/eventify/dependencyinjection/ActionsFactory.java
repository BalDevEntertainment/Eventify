package com.baldev.eventify.dependencyinjection;


import com.baldev.eventify.domain.actions.groups.AddUsersToGroupAction;
import com.baldev.eventify.domain.actions.groups.CreateGroupAction;
import com.baldev.eventify.domain.actions.users.CreateUserAction;
import com.baldev.eventify.domain.actions.groups.DefaultAddUsersToGroupAction;
import com.baldev.eventify.domain.actions.groups.DefaultCreateGroupAction;
import com.baldev.eventify.domain.actions.users.DefaultCreateUserAction;
import com.baldev.eventify.domain.actions.groups.DefaultGetGroupBeingCreatedAction;
import com.baldev.eventify.domain.actions.users.DefaultGetMyUserAction;
import com.baldev.eventify.domain.actions.users.DefaultGetUsersAction;
import com.baldev.eventify.domain.actions.users.DefaultSaveUserAction;
import com.baldev.eventify.domain.actions.users.GetMyUserAction;
import com.baldev.eventify.domain.actions.groups.GetGroupBeingCreatedAction;
import com.baldev.eventify.domain.actions.users.GetUsersAction;
import com.baldev.eventify.domain.actions.users.SaveUserAction;
import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory;

public abstract class ActionsFactory {
	public static CreateUserAction provideCreateUserAction() {
		return new DefaultCreateUserAction(ServicesFactory.provideCreateUserService());
	}

	public static SaveUserAction provideSaveUserAction() {
		return new DefaultSaveUserAction(ServicesFactory.provideSaveUserService());
	}

	public static CreateGroupAction provideCreateGroupAction() {
		return new DefaultCreateGroupAction(ServicesFactory.provideCreateGroupService());
	}

	public static GetGroupBeingCreatedAction provideGetGroupBeingCreated() {
		return new DefaultGetGroupBeingCreatedAction(RepositoriesFactory.provideGroupsRepository());
	}

	public static GetMyUserAction provideGetMyUserAction() {
		return new DefaultGetMyUserAction(RepositoriesFactory.provideUsersRepository());
	}

	public static GetUsersAction provideGetUsersAction() {
		return new DefaultGetUsersAction(RepositoriesFactory.provideUsersRepository());
	}

	public static AddUsersToGroupAction provideAddUsersToGroupAction() {
		return new DefaultAddUsersToGroupAction(ServicesFactory.provideAddUsersToGroupService());
	}
}
