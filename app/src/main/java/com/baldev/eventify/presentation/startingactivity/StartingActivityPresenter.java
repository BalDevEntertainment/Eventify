package com.baldev.eventify.presentation.startingactivity;


import com.baldev.eventify.domain.actions.StartApplication;
import com.baldev.eventify.domain.actions.ApplicationStartCallback;
import com.baldev.eventify.presentation.startingactivity.StartingActivityContract.View;
import com.google.common.base.Preconditions;

public class StartingActivityPresenter implements StartingActivityContract.Presenter {

	private StartApplication startApplication;

	public StartingActivityPresenter(StartApplication startApplication) {
		Preconditions.checkNotNull(startApplication);
		this.startApplication = startApplication;
	}

	@Override
	public void OnViewCreated(View view) {
		startApplication.execute(new ApplicationStartCallback() {
			@Override
			public void onUserFound() {
				view.startMainActivity();
			}

			@Override
			public void OnUserNotFound() {
				view.startCreateUserActivity();
			}
		});
	}
}
