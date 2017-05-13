package com.baldev.eventify.presentation.mainactivity;


import com.baldev.eventify.domain.entities.Group;

import java.util.List;

public interface MainActivityContract {

	interface View {

		void setGroupListToAdapter(List<Group> groups);
	}

	interface Presenter {

		void onResume();
	}
}
