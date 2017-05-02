package com.baldev.eventify.presentation.userlist;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.presentation.userlist.UserListContract.Presenter;
import com.baldev.eventify.presentation.userlist.UserListContract.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
		this.presenter = PresenterFactory.provideUserListPresenter(this);
	}

	@Override
	public void setUserListToAdapter(List<User> users) {
		this.userList.setAdapter(userListAdapter);
		this.userList.setLayoutManager(new LinearLayoutManager(this));
		this.userListAdapter.setItems(users);
		this.userListAdapter.notifyDataSetChanged();
	}
}
