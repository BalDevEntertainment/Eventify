package com.baldev.eventify.presentation.startingactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.baldev.eventify.dependencyinjection.FactoryProvider;
import com.baldev.eventify.domain.actions.StartApplication;
import com.baldev.eventify.presentation.createuser.CreateUserActivity;
import com.baldev.eventify.presentation.mainactivity.MainActivity;

public class StartingActivity extends AppCompatActivity implements StartingActivityContract.View {

	private StartingActivityPresenter presenter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SharedPreferences sharedPref = this.getSharedPreferences("User", Context.MODE_PRIVATE);
		StartApplication startApplication = FactoryProvider.actionsFactory().provideStartApplication(sharedPref);
		presenter = FactoryProvider.presenterFactory().provideStartingActivityPresenter(startApplication);
	}

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		View view = super.onCreateView(name, context, attrs);
		presenter.OnViewCreated(this);
		return view;
	}

	@Override
	public void startCreateUserActivity() {
		Intent intent = new Intent(StartingActivity.this, CreateUserActivity.class);
		startActivity(intent);
	}

	@Override
	public void startMainActivity() {
		Intent intent = new Intent(StartingActivity.this, MainActivity.class);
		startActivity(intent);
	}
}
