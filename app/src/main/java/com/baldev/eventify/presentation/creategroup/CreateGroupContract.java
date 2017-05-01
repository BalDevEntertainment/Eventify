package com.baldev.eventify.presentation.creategroup;


import android.support.v7.widget.RecyclerView;

import com.baldev.eventify.domain.entities.User;

import java.util.List;

public interface CreateGroupContract {

	interface View {
		void setUserListToAdapter(List<User> userListAdapter);
	}

	interface Presenter {

	}
}
