package com.baldev.eventify.presentation.createevent;


import com.baldev.eventify.domain.entities.Group;

import java.util.List;

public interface CreateEventContract {

	interface View {

		void setGroupListToSpinner(List<Group> groups);
	}

	interface Presenter {

	}
}
