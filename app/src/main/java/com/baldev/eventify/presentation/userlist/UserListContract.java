package com.baldev.eventify.presentation.userlist;


import com.baldev.eventify.domain.entities.User;

import java.util.List;

public interface UserListContract {

	interface View {

		void setUserListToAdapter(List<User> users);

		void returnList(int[] selectedUserIds);
	}

	interface Presenter {

		void onSaveButtonPressed(List<User> users);
	}
}
