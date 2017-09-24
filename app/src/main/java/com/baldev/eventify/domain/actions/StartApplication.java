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
			callback.OnUserNotFound();
		}
	}

	private void initializeDatabase(final ApplicationStartCallback callback) {
		String myUserId = sharedPreferences.getString(USER_ID_KEY, null);
		RepositoriesFactory.provideUsersRepository().initialize(myUserId,
				new DefaultRepositoryInitializationCallback(callback));
	}

	private class DefaultRepositoryInitializationCallback implements InitializeRepositoriesCallback {
		private ApplicationStartCallback callback;

		private DefaultRepositoryInitializationCallback(ApplicationStartCallback callback) {
			this.callback = callback;
		}

		@Override
		public void onDatabaseInitialized() {
			callback.onUserFound();
		}

		@Override
		public void onUserNotFound() {
			callback.OnUserNotFound();
		}
	}

	private boolean isUserSavedInSharedPreferences() {
		return sharedPreferences.contains(USER_ID_KEY);
	}
}
