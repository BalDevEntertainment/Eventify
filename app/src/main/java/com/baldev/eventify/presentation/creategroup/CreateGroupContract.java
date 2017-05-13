package com.baldev.eventify.presentation.creategroup;


import com.baldev.eventify.domain.entities.User;

import java.util.List;

public interface CreateGroupContract {

	interface View {
		void setUserListToAdapter(List<User> userListAdapter);

		void showInvalidGroupNameError();

		void finishActivity();
	}

	interface Presenter {

		void onSavePressed(String s);

		void onSelectedUsersRetrieved(int[] userIds);
	}
}
