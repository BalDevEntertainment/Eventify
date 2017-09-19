package com.baldev.eventify.presentation.startingactivity;


import com.baldev.eventify.domain.actions.StartApplication;
import com.google.common.base.Preconditions;

public class StartingActivityPresenter {

	private StartApplication startApplication;

	public StartingActivityPresenter(StartApplication startApplication) {
		Preconditions.checkNotNull(startApplication);
		this.startApplication = startApplication;
	}

	public void OnViewCreated() {
		startApplication.execute();
	}
}
