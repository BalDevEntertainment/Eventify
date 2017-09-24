package com.baldev.eventify.presentation.startingactivity;


public interface StartingActivityContract {
	interface Presenter {

		void OnViewCreated(View view);
	}

	interface View {

		void startCreateUserActivity();

		void startMainActivity();
	}

}
