package com.baldev.eventify.presentation.mainactivity;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.baldev.eventify.domain.actions.groups.GetMyGroups;
import com.baldev.eventify.presentation.mainactivity.MainActivityContract.Presenter;
import com.baldev.eventify.presentation.mainactivity.MainActivityContract.View;
import com.baldev.eventify.presentation.mainactivity.events.EventsFragment;
import com.baldev.eventify.presentation.mainactivity.groups.GroupsFragment;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPresenter implements Presenter {

	private final View view;

	public MainActivityPresenter(View view, GetMyGroups getMyGroups) {
		Preconditions.checkNotNull(getMyGroups);
		Preconditions.checkNotNull(view);
		this.view = view;
		initializePagerAdapter(view);
	}

	private void initializePagerAdapter(View view) {
		view.buildPagerAdapter(instantiateMainActivityPagerFragmentList());
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

	private List<MainActivityPagerFragmentBuilder> instantiateMainActivityPagerFragmentList() {
		List<MainActivityPagerFragmentBuilder> list = new ArrayList<>();
		list.add(getGroupsFragmentBuilder());
		list.add(getEventsFragmentBuilder());
		return list;
	}

	@NonNull
	private MainActivityPagerFragmentBuilder getEventsFragmentBuilder() {
		return new MainActivityPagerFragmentBuilder() {
			@Override
			public Fragment build() {
				return new EventsFragment();
			}

			@Override
			public String getPageTitle() {
				return EventsFragment.title;
			}
		};
	}

	@NonNull
	private MainActivityPagerFragmentBuilder getGroupsFragmentBuilder() {
		return new MainActivityPagerFragmentBuilder() {
			@Override
			public Fragment build() {
				return new GroupsFragment();
			}

			@Override
			public String getPageTitle() {
				return GroupsFragment.title;
			}
		};
	}
}
