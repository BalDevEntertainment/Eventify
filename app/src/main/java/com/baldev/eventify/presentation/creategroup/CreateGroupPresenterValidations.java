package com.baldev.eventify.presentation.creategroup;

import com.baldev.eventify.domain.actions.groups.CreateGroupAction;
import com.baldev.eventify.domain.actions.users.GetMyUserAction;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.View;
import com.google.common.base.Preconditions;

class CreateGroupPresenterValidations {
	private View view;
	private GetMyUserAction getMyUserAction;
	private final CreateGroupAction createGroupAction;

	public CreateGroupPresenterValidations(View view, CreateGroupAction createGroupAction, GetMyUserAction getMyUserAction) {
		this.view = view;
		this.createGroupAction = createGroupAction;
		this.getMyUserAction = getMyUserAction;
	}

	public void execute() {
		Preconditions.checkNotNull(view);
		Preconditions.checkNotNull(createGroupAction);
		Preconditions.checkNotNull(getMyUserAction);
	}
}
