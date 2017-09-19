package com.baldev.eventify.presentation.startingactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory;
import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory.InitializeRepositoriesCallback;
import com.baldev.eventify.presentation.createuser.CreateUserActivity;
import com.baldev.eventify.presentation.mainactivity.MainActivity;

public class StartingActivity extends AppCompatActivity {

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SharedPreferences sharedPref = this.getSharedPreferences("User", Context.MODE_PRIVATE);
		String myUserId = sharedPref.getString("MyUserId", "NotInitialized");

		RepositoriesFactory.provideUsersRepository().initialize(myUserId, new InitializeRepositoriesCallback() {
			@Override
			public void onDatabaseInitialized() {
				Intent intent = new Intent(StartingActivity.this, MainActivity.class);
				startActivity(intent);
			}

			@Override
			public void onUserNotFound() {
				Intent intent = new Intent(StartingActivity.this, CreateUserActivity.class);
				startActivity(intent);
			}
		});
	}
}
