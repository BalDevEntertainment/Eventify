package com.baldev.eventify.presentation.creategroup;

import android.app.Activity;
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
import android.widget.TextView;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.Presenter;
import com.baldev.eventify.presentation.userlist.UserListActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateGroupActivity extends AppCompatActivity implements CreateGroupContract.View {

	public static final int REQUEST_CODE_SELECTED_USER_IDS = 1;
	public static final String EXTRA_SELECTED_USER_IDS = "SELECTED_USER_IDS";

	private final SparseArrayCompat<CreateGroupMenuAction> menuActionsMap = new SparseArrayCompat<>();
	private final GroupUserListAdapter groupUserListAdapter = new GroupUserListAdapter();

	@BindView(R.id.user_list)
	protected RecyclerView userList;

	@BindView(R.id.group_name_input)
	protected TextView groupNameInput;

	private Presenter presenter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_create_group);
		ButterKnife.bind(this);
		setupToolbar();

		this.presenter = PresenterFactory.provideCreateGroupPresenter(this);
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
		startUserListActivityForResult();
	}

	@Override
	public void setUserListToAdapter(List<User> users) {
		this.userList.setAdapter(groupUserListAdapter);
		this.userList.setLayoutManager(new LinearLayoutManager(this));
		this.groupUserListAdapter.setItems(users);
		this.groupUserListAdapter.notifyDataSetChanged();
	}

	@Override
	public void showInvalidGroupNameError() {

	}

	@Override
	public void finishActivity() {
		this.finish();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (isResultValid(requestCode, resultCode)) {
			int[] userIds = data.getIntArrayExtra(EXTRA_SELECTED_USER_IDS);
			presenter.onSelectedUsersRetrieved(userIds);
		}
	}

	private void startUserListActivityForResult() {
		Intent intent = new Intent(this, UserListActivity.class);
		startActivityForResult(intent, REQUEST_CODE_SELECTED_USER_IDS);
	}

	private void save() {
		presenter.onSavePressed(groupNameInput.getText().toString());
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
		menuActionsMap.put(android.R.id.home, () -> {
			this.finish();
			return true;
		});
	}

	private boolean isToolbarSet() {
		return this.getSupportActionBar() != null;
	}

	private boolean isResultValid(int requestCode, int resultCode) {
		return requestCode == REQUEST_CODE_SELECTED_USER_IDS && resultCode == Activity.RESULT_OK;
	}

	private class TakeNoAction implements CreateGroupMenuAction {
		@Override
		public boolean execute() {
			return false;
		}
	}
}
