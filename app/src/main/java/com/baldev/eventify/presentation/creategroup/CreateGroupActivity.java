package com.baldev.eventify.presentation.creategroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.TextView;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.presentation.SaveToolbarActivity;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.Presenter;
import com.baldev.eventify.presentation.userlist.UserListActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateGroupActivity extends SaveToolbarActivity implements CreateGroupContract.View {

	public static final int REQUEST_CODE_SELECTED_USER_IDS = 1;
	public static final String EXTRA_SELECTED_USER_IDS = "SELECTED_USER_IDS";

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

		this.presenter = PresenterFactory.provideCreateGroupPresenter(this);
	}

	@OnClick(R.id.add_remove_members_button)
	public void onAddRemoveMembersButtonPressed() {
		presenter.onAddRemoveMemberButtonPressed();
	}

	@Override
	public void startUserListActivityForResult(int[] userIds) {
		Intent intent = new Intent(this, UserListActivity.class);
		intent.putExtra(EXTRA_SELECTED_USER_IDS, userIds);
		startActivityForResult(intent, REQUEST_CODE_SELECTED_USER_IDS);
	}

	@Override
	public void setUserListToAdapter(List<User> users) {
		GroupUserListAdapter groupUserListAdapter = new GroupUserListAdapter();
		this.userList.setAdapter(groupUserListAdapter);
		this.userList.setLayoutManager(new LinearLayoutManager(this));
		groupUserListAdapter.setItems(users);
		groupUserListAdapter.notifyDataSetChanged();
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

	@Override
	protected void save() {
		presenter.onSavePressed(groupNameInput.getText().toString());
	}

	private boolean isResultValid(int requestCode, int resultCode) {
		return requestCode == REQUEST_CODE_SELECTED_USER_IDS && resultCode == Activity.RESULT_OK;
	}

}
