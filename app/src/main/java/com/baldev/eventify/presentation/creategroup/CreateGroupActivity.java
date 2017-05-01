package com.baldev.eventify.presentation.creategroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.Menu;
import android.view.MenuItem;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.Presenter;
import com.baldev.eventify.presentation.userlist.UserListActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateGroupActivity extends AppCompatActivity implements CreateGroupContract.View {

	private final SparseArrayCompat<CreateGroupMenuAction> menuActionsMap = new SparseArrayCompat<>();

	@BindView(R.id.user_list)
	protected RecyclerView userList;

	@Inject
	private Presenter presenter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_create_group);
		ButterKnife.bind(this);
		this.presenter = PresenterFactory.provideCreateGroupPresenter(this);
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
	public void setUserListAdapter(Adapter adapter) {
		this.userList.setAdapter(adapter);
		this.userList.setLayoutManager(new LinearLayoutManager(this));
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
