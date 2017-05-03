package com.baldev.eventify.presentation.createevent;

import com.baldev.eventify.presentation.createevent.CreateEventContract.Presenter;
import com.baldev.eventify.presentation.createuser.CreateUserContract.View;
import com.google.common.base.Preconditions;


class CreateEventPresenter implements Presenter {
	public CreateEventPresenter(View view) {
		Preconditions.checkNotNull(view);
	}
}
