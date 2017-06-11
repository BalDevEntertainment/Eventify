package com.baldev.eventify.presentation.mainactivity.groups;


import com.baldev.eventify.domain.actions.groups.GetMyGroups;
import com.baldev.eventify.domain.entities.Group;

import java.util.List;

public class GroupsFragmentPresenter {

	protected List<Group> groups;
	private GroupsFragment view;
	private GetMyGroups getMyGroups;

	public GroupsFragmentPresenter(GroupsFragment view, GetMyGroups getMyGroups) {
		this.view = view;
		this.getMyGroups = getMyGroups;
		retrieveGroupList();
	}

	public void onViewCreated() {
		initializeGroupListAdapter(view);
	}

	public void onResume() {
		retrieveGroupList();
		initializeGroupListAdapter(view);
	}

	private void retrieveGroupList() {
		groups = getMyGroups.execute();
	}

	private void initializeGroupListAdapter(GroupsFragment view) {
		view.setGroupListToAdapter(groups);
	}
}
