package com.baldev.eventify.presentation.userlist;

import com.baldev.eventify.domain.actions.GetUsersAction;
import com.baldev.eventify.presentation.userlist.UserListContract.Presenter;
import com.baldev.eventify.presentation.userlist.UserListContract.View;
import com.google.common.base.Preconditions;


public class UserListPresenter implements Presenter {
	public UserListPresenter(View view, GetUsersAction getUsersAction) {
		Preconditions.checkNotNull(view);
		Preconditions.checkNotNull(getUsersAction);

	}
}
