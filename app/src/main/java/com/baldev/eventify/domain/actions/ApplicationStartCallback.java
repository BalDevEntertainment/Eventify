package com.baldev.eventify.domain.actions;

public interface ApplicationStartCallback {
	void onApplicationStartedSuccessfully();

	void onApplicationStartFailed();
}
