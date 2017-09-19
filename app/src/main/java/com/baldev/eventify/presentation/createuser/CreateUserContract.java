package com.baldev.eventify.presentation.createuser;


public interface CreateUserContract {

	interface View {

		String getUserName();

		void startMainActivity();

		void saveUserIdLocallyOnPhone();
	}

	interface Presenter {

		void acceptButtonPressed();
	}
}
