package com.baldev.eventify.presentation.mainactivity;

import com.baldev.eventify.domain.actions.groups.GetMyGroups;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.presentation.mainactivity.MainActivityContract.Presenter;
import com.baldev.eventify.presentation.mainactivity.MainActivityContract.View;
import com.google.common.base.Preconditions;

import java.util.List;

public class MainActivityPresenter implements Presenter {

	protected List<Group> groups;
	private GetMyGroups getMyGroups;
	private final View view;

	public MainActivityPresenter(View view, GetMyGroups getMyGroups) {
		Preconditions.checkNotNull(getMyGroups);
		Preconditions.checkNotNull(view);
		this.view = view;
		this.getMyGroups = getMyGroups;
		retrieveGroupList();
		initializeGroupListAdapter(view);
	}

	@Override
	public void onResume() {
		retrieveGroupList();
		initializeGroupListAdapter(view);
	}

	@Override
	public void onCreateGroupPressed() {
		view.collapseFabMenu();
		view.startCreateGroupActivity();
	}

	@Override
	public void onCreateEventPressed() {
		view.collapseFabMenu();
		view.startCreateEventActivity();
	}

	private void retrieveGroupList() {
		groups = getMyGroups.execute();
	}

	private void initializeGroupListAdapter(MainActivityContract.View view) {
		view.setGroupListToAdapter(groups);
	}
}
