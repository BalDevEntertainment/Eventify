package com.baldev.eventify.presentation.creategroup;

import com.baldev.eventify.domain.actions.CreateGroupAction;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.Presenter;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.View;
import com.google.common.base.Preconditions;

import javax.inject.Inject;

public class CreateGroupPresenter implements Presenter {

	@Inject
	public CreateGroupPresenter(View view, CreateGroupAction createGroupAction) {
		Preconditions.checkNotNull(view);
		Preconditions.checkNotNull(createGroupAction);
	}
}
