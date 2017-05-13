package com.baldev.eventify.presentation.createuser;


public interface CreateUserContract {

	interface View {

		String getUserName();

		void startMainActivity();
	}

	interface Presenter {

		void acceptButtonPressed();
	}
}
