package com.baldev.eventify.presentation.createevent;


import java.util.Date;
import java.util.Set;

public interface CreateEventContract {

	interface View {

		void setGroupListToSpinner(Set<String> groups);

		String getSelectedGroupName();

		String getEventDescription();

		Date getDate();

		String getDuration();
	}

	interface Presenter {

		void onSaveEventButtonPressed();
	}
}
