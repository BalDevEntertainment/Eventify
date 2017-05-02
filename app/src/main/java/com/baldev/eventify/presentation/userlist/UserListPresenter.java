package com.baldev.eventify.presentation.userlist;

import com.baldev.eventify.domain.actions.GetUsersAction;
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

	@Inject
	public UserListPresenter(View view, GetUsersAction getUsersAction) {
		Preconditions.checkNotNull(view);
		Preconditions.checkNotNull(getUsersAction);
		this.view = view;
		this.getUsersAction = getUsersAction;
		initializeUserListAdapter();
	}

	private void initializeUserListAdapter() {
		getUsersAction.execute(this);
	}

	@Override
	public void onUsersRetrieved(List<User> users) {
		view.setUserListToAdapter(users);
	}
}
