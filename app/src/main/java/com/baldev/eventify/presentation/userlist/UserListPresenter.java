package com.baldev.eventify.presentation.userlist;

import android.support.annotation.NonNull;

import com.baldev.eventify.domain.actions.users.GetUsersAction;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.repositories.GetUsersCallback;
import com.baldev.eventify.presentation.userlist.UserListContract.Presenter;
import com.baldev.eventify.presentation.userlist.UserListContract.View;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class UserListPresenter implements Presenter, GetUsersCallback {

	private final View view;
	private final GetUsersAction getUsersAction;
	private final List<User> preselectUsers;

	@Inject
	public UserListPresenter(View view, List<User> preselectUsers, GetUsersAction getUsersAction) {
		Preconditions.checkNotNull(view);
		Preconditions.checkNotNull(getUsersAction);
		this.view = view;
		this.getUsersAction = getUsersAction;
		this.preselectUsers = preselectUsers;
		initializeUserListAdapter();
	}

	private void initializeUserListAdapter() {
		getUsersAction.execute(this);
	}

	@Override
	public void onUsersRetrieved(List<User> users) {
		List<UserListItem> userListForAdapter = getUserListItems(users);
		view.setUserListToAdapter(userListForAdapter);
	}

	@Override
	public void onSaveButtonPressed(List<User> users) {
		view.returnList(users);
	}

	@NonNull
	private List<UserListItem> getUserListItems(List<User> users) {
		List<UserListItem> userListForAdapter = new ArrayList<>();
		for (User user : users) {
			userListForAdapter.add(new UserListItem(user, isPreselected(user)));
		}
		return userListForAdapter;
	}

	private boolean isPreselected(User user) {
		for (User preselectUser : this.preselectUsers) {
			if (user.getId().equals(preselectUser.getId())) {
				return true;
			}
		}
		return false;
	}
}
