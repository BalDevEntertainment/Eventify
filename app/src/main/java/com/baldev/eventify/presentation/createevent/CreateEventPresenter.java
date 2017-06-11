package com.baldev.eventify.presentation.createevent;

import android.support.annotation.NonNull;

import com.baldev.eventify.domain.actions.events.SaveEvent;
import com.baldev.eventify.domain.actions.groups.GetMyGroups;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.exceptions.NoGroupSelectedException;
import com.baldev.eventify.presentation.createevent.CreateEventContract.Presenter;
import com.baldev.eventify.presentation.createevent.CreateEventContract.View;
import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreateEventPresenter implements Presenter {

	protected Map<String, Group> groupNameMap = new HashMap<>();
	private SaveEvent saveEvent;
	private View view;

	public CreateEventPresenter(View view, GetMyGroups getMyGroups, SaveEvent saveEvent) {
		Preconditions.checkNotNull(view);
		Preconditions.checkNotNull(getMyGroups);
		Preconditions.checkNotNull(saveEvent);
		this.saveEvent = saveEvent;
		this.view = view;
		initializeGroupNameMap(getMyGroups.execute());
		view.setGroupListToSpinner(groupNameMap.keySet());
	}

	@Override
	public void onSaveEventButtonPressed() {
		try {
		saveEvent.execute(getSelectedGroupByName(view.getSelectedGroupName()), view.getEventDescription(), view.getDate(), Integer.valueOf(view.getDuration()));
		view.finishActivity();
		} catch (NoGroupSelectedException e) {
			view.showNoGroupSelectedError();
		}
	}

	private Group getSelectedGroupByName(String selectedGroupName) {
		return groupNameMap.get(selectedGroupName);
	}

	@NonNull
	private void initializeGroupNameMap(List<Group> groups) {
		groupNameMap.clear();
		for (Group group : groups) {
			groupNameMap.put(group.getName(), group);
		}
	}
}
