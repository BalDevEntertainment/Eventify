package com.baldev.eventify.presentation.creategroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.Presenter;
import com.baldev.eventify.presentation.userlist.UserListActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateGroupActivity extends AppCompatActivity implements CreateGroupContract.View {

	private final SparseArrayCompat<CreateGroupMenuAction> menuActionsMap = new SparseArrayCompat<>();
	private final UserListAdapter userListAdapter = new UserListAdapter();

	@BindView(R.id.user_list)
	protected RecyclerView userList;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_create_group);
		ButterKnife.bind(this);
		setupToolbar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_create_group, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return menuActionsMap.get(item.getItemId(), new TakeNoAction()).execute();
	}

	@OnClick(R.id.add_remove_members_button)
	public void onAddRemoveMembersButtonPressed() {
		startUserListActivity();
	}

	@Override
	public void setUserListToAdapter(List<User> users) {
		this.userList.setAdapter(userListAdapter);
		this.userList.setLayoutManager(new LinearLayoutManager(this));
		this.userListAdapter.setItems(users);
		this.userListAdapter.notifyDataSetChanged();
	}

	private void startUserListActivity() {
		Intent intent = new Intent(this, UserListActivity.class);
		startActivity(intent);
	}

	private void save() {

	}

	private void setupToolbar() {
		if (isToolbarSet()) {
			ActionBar actionBar = this.getSupportActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
			actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_close_clear_cancel);
			setActionBarActions();
		}
	}

	private void setActionBarActions() {
		menuActionsMap.put(R.id.action_menu_save, () -> {
			save();
			return true;
		});
	}

	private boolean isToolbarSet() {
		return this.getSupportActionBar() != null;
	}

	private class TakeNoAction implements CreateGroupMenuAction {
		@Override
		public boolean execute() {
			return false;
		}
	}
}
