package com.baldev.eventify.presentation.userlist;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.presentation.userlist.UserListContract.Presenter;
import com.baldev.eventify.presentation.userlist.UserListContract.View;

import butterknife.ButterKnife;

public class UserListActivity extends AppCompatActivity implements View {

	private Presenter presenter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_user_list);
		ButterKnife.bind(this);
		this.presenter = PresenterFactory.provideUserListPresenter(this);
	}
}
