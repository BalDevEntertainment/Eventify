package com.baldev.eventify.presentation.createuser;


public interface CreateUserContract {

	interface View {

		String getUserName();
	}

	interface Presenter {

		void acceptButtonPressed();
	}
}
