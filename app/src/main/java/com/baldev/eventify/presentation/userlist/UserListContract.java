package com.baldev.eventify.presentation.userlist;


import com.baldev.eventify.domain.entities.User;

import java.util.List;

public interface UserListContract {

	interface View {

		void setUserListToAdapter(List<UserListItem> users);

		void returnList(List<User> users);
	}

	interface Presenter {

		void onSaveButtonPressed(List<User> users);
	}
}
