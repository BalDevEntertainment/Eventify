package com.baldev.eventify.presentation.createuser;


public interface CreateUserContract {

	interface View {

		String getUserName();

		void startCreateGroupActivity();
	}

	interface Presenter {

		void acceptButtonPressed();
	}
}
