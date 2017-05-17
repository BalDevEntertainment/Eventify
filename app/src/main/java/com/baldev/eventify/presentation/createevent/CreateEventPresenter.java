package com.baldev.eventify.presentation.createevent;

import com.baldev.eventify.domain.actions.groups.GetMyGroups;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.presentation.createevent.CreateEventContract.Presenter;
import com.baldev.eventify.presentation.createevent.CreateEventContract.View;
import com.google.common.base.Preconditions;

import java.util.List;


public class CreateEventPresenter implements Presenter {

	public CreateEventPresenter(View view, GetMyGroups getMyGroups) {
		Preconditions.checkNotNull(view);
		Preconditions.checkNotNull(getMyGroups);
		view.setGroupListToSpinner(getMyGroups.execute());
	}
}
