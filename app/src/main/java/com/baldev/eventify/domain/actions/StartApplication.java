package com.baldev.eventify.domain.actions;


import android.content.SharedPreferences;

import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory;
import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory.InitializeRepositoriesCallback;

public class StartApplication {
	private static final String USER_ID_KEY = "MyUserId";
	private SharedPreferences sharedPreferences;

	public StartApplication(SharedPreferences sharedPreferences) {
		this.sharedPreferences = sharedPreferences;
	}

	public void execute(ApplicationStartCallback callback) {
		if (isUserSavedInSharedPreferences()) {
			initializeDatabase(callback);
		} else {
			callback.onApplicationStartFailed();
		}
	}

	private void initializeDatabase(final ApplicationStartCallback callback) {
		initializeUserDatabase(new InitializeRepositoriesCallback() {
			@Override
			public void onRepositoryInitialized() {
				initializeGroupDatabase(new InitializeRepositoriesCallback() {
					@Override
					public void onRepositoryInitialized() {
						callback.onApplicationStartedSuccessfully();
					}

					@Override
					public void onRepositoryInitializationFailed() {
						callback.onApplicationStartFailed();
					}
				});
			}

			@Override
			public void onRepositoryInitializationFailed() {
				callback.onApplicationStartFailed();
			}
		});
	}

	private void initializeGroupDatabase(InitializeRepositoriesCallback callback) {
		RepositoriesFactory.provideGroupsRepository().initialize(new InitializeRepositoriesCallback() {
			@Override
			public void onRepositoryInitialized() {
				callback.onRepositoryInitialized();
			}

			@Override
			public void onRepositoryInitializationFailed() {
				callback.onRepositoryInitializationFailed();
			}
		});
	}

	private void initializeUserDatabase(InitializeRepositoriesCallback callback) {
		String myUserId = sharedPreferences.getString(USER_ID_KEY, null);
		RepositoriesFactory.provideUsersRepository().initialize(myUserId, new InitializeRepositoriesCallback() {
			@Override
			public void onRepositoryInitialized() {
				callback.onRepositoryInitialized();
			}

			@Override
			public void onRepositoryInitializationFailed() {
				callback.onRepositoryInitializationFailed();
			}
		});
	}

	private boolean isUserSavedInSharedPreferences() {
		return sharedPreferences.contains(USER_ID_KEY);
	}
}
