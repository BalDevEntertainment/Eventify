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
			initializeRepositories(callback);
		} else {
			callback.onApplicationStartFailed();
		}
	}

	private void initializeRepositories(final ApplicationStartCallback callback) {
		initializeUserRepository(
				initializeGroupsRepository(
						initializeEventsRepository(callback::onApplicationStartedSuccessfully, callback), callback), callback);
	}

	private void initializeUserRepository(RepositoryInitializationCallback repositoryInitializationCallback, ApplicationStartCallback callback) {
		String myUserId = sharedPreferences.getString(USER_ID_KEY, null);
		RepositoriesFactory.provideUsersRepository().initialize(myUserId, new DefaultRepositoryInitializationCallback(repositoryInitializationCallback, callback));
	}

	private RepositoryInitializationCallback initializeGroupsRepository(RepositoryInitializationCallback repositoryInitializationCallback, ApplicationStartCallback callback) {
		return () -> RepositoriesFactory.provideGroupsRepository().initialize(new DefaultRepositoryInitializationCallback(repositoryInitializationCallback, callback));
	}

	private RepositoryInitializationCallback initializeEventsRepository(RepositoryInitializationCallback repositoryInitializationCallback, ApplicationStartCallback callback) {
		return () -> RepositoriesFactory.provideEventsRepository().initialize(new DefaultRepositoryInitializationCallback(repositoryInitializationCallback, callback));
	}

	private interface RepositoryInitializationCallback {
		void onInitializationComplete();
	}

	private class DefaultRepositoryInitializationCallback implements InitializeRepositoriesCallback {

		private ApplicationStartCallback callback;
		private RepositoryInitializationCallback repositoryInitializationCallback;

		private DefaultRepositoryInitializationCallback(RepositoryInitializationCallback repositoryInitializationCallback,
														ApplicationStartCallback callback) {
			this.repositoryInitializationCallback = repositoryInitializationCallback;
			this.callback = callback;
		}

		@Override
		public void onRepositoryInitialized() {
			repositoryInitializationCallback.onInitializationComplete();
		}

		@Override
		public void onRepositoryInitializationFailed() {
			this.callback.onApplicationStartFailed();
		}
	}

	private boolean isUserSavedInSharedPreferences() {
		return sharedPreferences.contains(USER_ID_KEY);
	}
}
