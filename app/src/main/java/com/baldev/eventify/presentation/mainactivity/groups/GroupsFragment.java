package com.baldev.eventify.presentation.mainactivity.groups;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.FactoryProvider;
import com.baldev.eventify.domain.entities.Group;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GroupsFragment extends Fragment {

	public static final String title = "GROUPS";

	private final GroupListAdapter groupListAdapter = new GroupListAdapter();

	@BindView(R.id.group_list)
	protected RecyclerView groupList;
	private GroupsFragmentPresenter presenter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		presenter = FactoryProvider.presenterFactory().provideGroupsFragmentPresenter(this);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_groups, container, false);
		ButterKnife.bind(this, view);
		presenter.onViewCreated();
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		presenter.onResume();
	}

	public void setGroupListToAdapter(List<Group> groups) {
		this.groupList.setAdapter(groupListAdapter);
		this.groupList.setLayoutManager(new LinearLayoutManager(this.getActivity()));
		this.groupListAdapter.setItems(groups);
		this.groupListAdapter.notifyDataSetChanged();
	}
}
