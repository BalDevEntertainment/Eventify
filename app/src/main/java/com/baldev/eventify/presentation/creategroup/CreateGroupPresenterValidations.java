package com.baldev.eventify.presentation.creategroup;

import com.baldev.eventify.domain.actions.groups.CreateGroup;
import com.baldev.eventify.domain.actions.users.GetMyUser;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.View;
import com.google.common.base.Preconditions;

class CreateGroupPresenterValidations {
	private View view;
	private GetMyUser getMyUser;
	private final CreateGroup createGroup;

	public CreateGroupPresenterValidations(View view, CreateGroup createGroup, GetMyUser getMyUser) {
		this.view = view;
		this.createGroup = createGroup;
		this.getMyUser = getMyUser;
	}

	public void execute() {
		Preconditions.checkNotNull(view);
		Preconditions.checkNotNull(createGroup);
		Preconditions.checkNotNull(getMyUser);
	}
}
