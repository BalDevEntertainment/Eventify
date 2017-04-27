package com.baldev.eventify.domain.actions;


public interface LoginCallback {
	void onLoginSuccessful();

	void onLoginFailed();
}
