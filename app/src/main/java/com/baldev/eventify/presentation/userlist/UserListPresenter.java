package com.baldev.eventify.presentation.userlist;

import com.baldev.eventify.domain.actions.groups.AddUsersToGroupAction;
import com.baldev.eventify.domain.actions.groups.GetGroupBeingCreatedAction;
import com.baldev.eventify.domain.actions.users.GetUsersAction;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.GetUsersCallback;
import com.baldev.eventify.presentation.userlist.UserListContract.Presenter;
import com.baldev.eventify.presentation.userlist.UserListContract.View;
import com.google.common.base.Preconditions;

import java.util.List;

import javax.inject.Inject;


public class UserListPresenter implements Presenter, GetUsersCallback {

	private final View view;
	private final GetUsersAction getUsersAction;
	private final AddUsersToGroupAction addUsersToGroupAction;
	private final GetGroupBeingCreatedAction getGroupBeingCreatedAction;

	@Inject
	public UserListPresenter(View view, GetUsersAction getUsersAction, AddUsersToGroupAction addUsersToGroupAction,
							 GetGroupBeingCreatedAction getGroupBeingCreatedAction) {
		Preconditions.checkNotNull(view);
		Preconditions.checkNotNull(getUsersAction);
		Preconditions.checkNotNull(addUsersToGroupAction);
		Preconditions.checkNotNull(getGroupBeingCreatedAction);
		this.view = view;
		this.getUsersAction = getUsersAction;
		this.addUsersToGroupAction = addUsersToGroupAction;
		this.getGroupBeingCreatedAction = getGroupBeingCreatedAction;
		initializeUserListAdapter();
	}

	private void initializeUserListAdapter() {
		getUsersAction.execute(this);
	}

	@Override
	public void onUsersRetrieved(List<User> users) {
		view.setUserListToAdapter(users);
		Group group = this.getGroupBeingCreatedAction.execute();
		this.addUsersToGroupAction.execute(group, users);
	}
}
