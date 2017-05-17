package com.baldev.eventify.presentation.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.presentation.createevent.CreateEventActivity;
import com.baldev.eventify.presentation.creategroup.CreateGroupActivity;
import com.baldev.eventify.presentation.mainactivity.MainActivityContract.Presenter;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

	private final GroupListAdapter groupListAdapter = new GroupListAdapter();

	@Inject
	private Presenter presenter;

	@BindView(R.id.group_list)
	protected RecyclerView userList;

	@BindView(R.id.fab_actions)
	protected FloatingActionsMenu fabMenu;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		this.presenter = PresenterFactory.provideMainActivityPresenter(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		presenter.onResume();
	}

	@Override
	public void setGroupListToAdapter(List<Group> groups) {
		this.userList.setAdapter(groupListAdapter);
		this.userList.setLayoutManager(new LinearLayoutManager(this));
		this.groupListAdapter.setItems(groups);
		this.groupListAdapter.notifyDataSetChanged();
	}

	@Override
	public void collapseFabMenu() {
		fabMenu.collapse();
	}

	@Override
	public void startCreateGroupActivity() {
		Intent intent = new Intent(this, CreateGroupActivity.class);
		startActivity(intent);
	}

	@Override
	public void startCreateEventActivity() {
		Intent intent = new Intent(this, CreateEventActivity.class);
		startActivity(intent);
	}

	@OnClick(R.id.create_group)
	public void onFabCreateGroupPressed() {
		presenter.onCreateGroupPressed();
	}

	@OnClick(R.id.create_event)
	public void onFabCreateEventPressed() {
		presenter.onCreateEventPressed();
	}
}
