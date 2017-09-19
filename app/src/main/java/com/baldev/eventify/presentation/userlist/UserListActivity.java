package com.baldev.eventify.presentation.userlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.FactoryProvider;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.presentation.userlist.UserListContract.Presenter;
import com.baldev.eventify.presentation.userlist.UserListContract.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.baldev.eventify.presentation.creategroup.CreateGroupActivity.EXTRA_SELECTED_USERS;

public class UserListActivity extends AppCompatActivity implements View {
	private final UserListAdapter userListAdapter = new UserListAdapter();

	@BindView(R.id.user_list)
	protected RecyclerView userList;

	private Presenter presenter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_user_list);
		ButterKnife.bind(this);
		List<User> preselectedUsers = getPreselectedUsersFromExtras();
		this.presenter = FactoryProvider.presenterFactory().provideUserListPresenter(this, preselectedUsers);
	}

	@Override
	public void setUserListToAdapter(List<UserListItem> userListItems) {
		this.userList.setAdapter(userListAdapter);
		this.userList.setLayoutManager(new LinearLayoutManager(this));
		this.userListAdapter.setItems(userListItems);
		this.userListAdapter.notifyDataSetChanged();
	}

	@OnClick(R.id.save_button)
	public void onSaveButtonPressed() {
		presenter.onSaveButtonPressed(this.userListAdapter.getSelectedItems());
	}

	@Override
	public void returnList(List<User> selectedUsers) {
		Intent returnIntent = new Intent();
		returnIntent.putExtra(EXTRA_SELECTED_USERS, (ArrayList) selectedUsers);
		setResult(Activity.RESULT_OK, returnIntent);
		finish();
	}

	private List<User> getPreselectedUsersFromExtras() {
		Bundle extras = getIntent().getExtras();
		return extras.containsKey(EXTRA_SELECTED_USERS) ?
				(ArrayList<User>) extras.getSerializable(EXTRA_SELECTED_USERS) : new ArrayList<>();
	}
}
