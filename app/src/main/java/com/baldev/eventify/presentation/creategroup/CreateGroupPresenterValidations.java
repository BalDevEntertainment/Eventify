package com.baldev.eventify.presentation.creategroup;

import com.baldev.eventify.domain.actions.CreateGroupAction;
import com.baldev.eventify.domain.actions.GetMyUserAction;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.View;
import com.google.common.base.Preconditions;

class CreateGroupPresenterValidations {
	private View view;
	private CreateGroupAction createGroupAction;
	private GetMyUserAction getMyUserAction;

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
