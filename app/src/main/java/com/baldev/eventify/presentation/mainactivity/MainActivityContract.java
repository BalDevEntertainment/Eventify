package com.baldev.eventify.presentation.mainactivity;


import com.baldev.eventify.domain.entities.Group;

import java.util.List;

public interface MainActivityContract {

	interface View {

		void setGroupListToAdapter(List<Group> groups);

		void collapseFabMenu();

		void startCreateGroupActivity();
	}

	interface Presenter {

		void onResume();

		void onCreateGroupPressed();
	}
}
