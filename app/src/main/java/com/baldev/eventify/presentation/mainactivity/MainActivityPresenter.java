package com.baldev.eventify.presentation.mainactivity;

import com.baldev.eventify.domain.actions.groups.GetMyGroupsAction;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.presentation.mainactivity.MainActivityContract.Presenter;
import com.baldev.eventify.presentation.mainactivity.MainActivityContract.View;
import com.google.common.base.Preconditions;

import java.util.List;

public class MainActivityPresenter implements Presenter {

	protected List<Group> groups;
	private GetMyGroupsAction getMyGroupsAction;
	private final View view;

	public MainActivityPresenter(View view, GetMyGroupsAction getMyGroupsAction) {
		Preconditions.checkNotNull(getMyGroupsAction);
		Preconditions.checkNotNull(view);
		this.view = view;
		this.getMyGroupsAction = getMyGroupsAction;
		retrieveGroupList();
		initializeGroupListAdapter(view);
	}

	@Override
	public void onResume() {
		retrieveGroupList();
		initializeGroupListAdapter(view);
	}

	private void retrieveGroupList() {
		groups = getMyGroupsAction.execute();
	}

	private void initializeGroupListAdapter(MainActivityContract.View view) {
		view.setGroupListToAdapter(groups);
	}
}
