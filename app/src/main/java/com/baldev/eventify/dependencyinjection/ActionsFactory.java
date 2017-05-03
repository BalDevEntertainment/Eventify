package com.baldev.eventify.dependencyinjection;


import com.baldev.eventify.domain.actions.AddUsersToGroupAction;
import com.baldev.eventify.domain.actions.CreateGroupAction;
import com.baldev.eventify.domain.actions.CreateUserAction;
import com.baldev.eventify.domain.actions.DefaultAddUsersToGroupAction;
import com.baldev.eventify.domain.actions.DefaultCreateGroupAction;
import com.baldev.eventify.domain.actions.DefaultCreateUserAction;
import com.baldev.eventify.domain.actions.DefaultGetGroupBeingCreatedAction;
import com.baldev.eventify.domain.actions.DefaultGetMyUserAction;
import com.baldev.eventify.domain.actions.DefaultGetUsersAction;
import com.baldev.eventify.domain.actions.DefaultSaveUserAction;
import com.baldev.eventify.domain.actions.GetMyUserAction;
import com.baldev.eventify.domain.actions.GetGroupBeingCreatedAction;
import com.baldev.eventify.domain.actions.GetUsersAction;
import com.baldev.eventify.domain.actions.SaveUserAction;
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
