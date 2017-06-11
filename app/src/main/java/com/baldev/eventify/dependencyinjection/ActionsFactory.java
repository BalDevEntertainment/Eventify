package com.baldev.eventify.dependencyinjection;


import com.baldev.eventify.domain.actions.events.DefaultGetMyEvents;
import com.baldev.eventify.domain.actions.events.DefaultSaveEvent;
import com.baldev.eventify.domain.actions.events.GetMyEvents;
import com.baldev.eventify.domain.actions.events.SaveEvent;
import com.baldev.eventify.domain.actions.groups.AddUsersToGroupAction;
import com.baldev.eventify.domain.actions.groups.CreateGroupAction;
import com.baldev.eventify.domain.actions.groups.DefaultAddUsersToGroupAction;
import com.baldev.eventify.domain.actions.groups.DefaultCreateGroupAction;
import com.baldev.eventify.domain.actions.groups.DefaultGetMyGroups;
import com.baldev.eventify.domain.actions.groups.GetMyGroups;
import com.baldev.eventify.domain.actions.users.DefaultFindUsersAction;
import com.baldev.eventify.domain.actions.users.DefaultGetMyUserAction;
import com.baldev.eventify.domain.actions.users.DefaultGetUsersAction;
import com.baldev.eventify.domain.actions.users.DefaultSaveUserAction;
import com.baldev.eventify.domain.actions.users.FindUsersAction;
import com.baldev.eventify.domain.actions.users.GetMyUserAction;
import com.baldev.eventify.domain.actions.users.GetUsersAction;
import com.baldev.eventify.domain.actions.users.SaveUserAction;
import com.baldev.eventify.domain.repositories.GroupsRepository;
import com.baldev.eventify.domain.repositories.UsersRepository;
import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory;

public abstract class ActionsFactory {

	private static GroupsRepository groupsRepository = RepositoriesFactory.provideGroupsRepository();
	private static UsersRepository usersRepository = RepositoriesFactory.provideUsersRepository();

	public static SaveUserAction provideSaveUserAction() {
		return new DefaultSaveUserAction(ServicesFactory.provideCreateUserService(), ServicesFactory.provideSaveUserService());
	}

	public static CreateGroupAction provideCreateGroupAction() {
		return new DefaultCreateGroupAction(ServicesFactory.provideGroupService());
	}

	public static GetMyUserAction provideGetMyUserAction() {
		return new DefaultGetMyUserAction(usersRepository);
	}

	public static FindUsersAction provideFindUsersAction() {
		return new DefaultFindUsersAction(usersRepository);
	}

	public static GetUsersAction provideGetUsersAction() {
		return new DefaultGetUsersAction(usersRepository);
	}

	public static AddUsersToGroupAction provideAddUsersToGroupAction() {
		return new DefaultAddUsersToGroupAction(ServicesFactory.provideAddUsersToGroupService());
	}

	public static GetMyGroups provideGetMyGroupsAction() {
		return new DefaultGetMyGroups(groupsRepository, provideGetMyUserAction());
	}

	public static GetMyEvents provideGetMyEvents() {
		return new DefaultGetMyEvents(RepositoriesFactory.provideEventsRepository(), provideGetMyUserAction());
	}

	public static SaveEvent provideSaveEvent() {
		return new DefaultSaveEvent(ServicesFactory.provideCreateEventService(), ServicesFactory.provideSaveEvent());
	}
}
