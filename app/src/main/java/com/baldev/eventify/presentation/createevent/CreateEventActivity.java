package com.baldev.eventify.presentation.createevent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.presentation.SaveToolbarActivity;
import com.baldev.eventify.presentation.createevent.CreateEventContract.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CreateEventActivity extends SaveToolbarActivity implements View {

	@BindView(R.id.group_spinner)
	protected Spinner groupsSpinner;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_event);
		ButterKnife.bind(this);
		PresenterFactory.provideCreateEventPresenter(this);
	}

	@Override
	protected void save() {

	}

	@Override
	public void setGroupListToSpinner(List<Group> groups) {
		List<String> groupNames = retrieveGroupNames(groups);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
		adapter.addAll(groupNames);
		groupsSpinner.setAdapter(adapter);
	}

	@NonNull
	private List<String> retrieveGroupNames(List<Group> groups) {
		List<String> groupNames = new ArrayList<>();
		for (Group group : groups) {
			groupNames.add(group.getName());
		}
		return groupNames;
	}
}
