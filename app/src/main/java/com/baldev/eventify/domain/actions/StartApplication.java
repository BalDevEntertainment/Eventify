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
			initializeRepositories(new InitializeRepositoriesCallback() {
				@Override
				public void onRepositoryInitialized() {
					callback.onApplicationStartedSuccessfully();
				}

				@Override
				public void onRepositoryInitializationFailed() {
					callback.onApplicationStartFailed();
				}
			});
		} else {
			callback.onApplicationStartFailed();
		}
	}

	private void initializeRepositories(final InitializeRepositoriesCallback callback) {
		initializeUserRepository(new InitializeRepositoriesCallback() {
			@Override
			public void onRepositoryInitialized() {
				onUsersRepositoryInitialized(callback);
			}

			@Override
			public void onRepositoryInitializationFailed() {
				callback.onRepositoryInitializationFailed();
			}
		});
	}

	private void onUsersRepositoryInitialized(final InitializeRepositoriesCallback callback) {
		initializeGroupRepository(new InitializeRepositoriesCallback() {
			@Override
			public void onRepositoryInitialized() {
				onGroupsRepositoryInitialized(callback);
			}

			@Override
			public void onRepositoryInitializationFailed() {
				callback.onRepositoryInitializationFailed();
			}
		});
	}

	private void onGroupsRepositoryInitialized(final InitializeRepositoriesCallback callback) {
		initializeEventsRepository(new InitializeRepositoriesCallback() {
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

	private void initializeUserRepository(InitializeRepositoriesCallback callback) {
		String myUserId = sharedPreferences.getString(USER_ID_KEY, null);
		RepositoriesFactory.provideUsersRepository().initialize(myUserId,
				new DefaultRepositoryInitializationCallback(callback));
	}

	private void initializeGroupRepository(InitializeRepositoriesCallback callback) {
		RepositoriesFactory.provideGroupsRepository().initialize(new DefaultRepositoryInitializationCallback(callback));
	}

	private void initializeEventsRepository(final InitializeRepositoriesCallback callback) {
		RepositoriesFactory.provideGroupsRepository().initialize(new DefaultRepositoryInitializationCallback(callback));
	}


	private class Wrapper {

	}

	private class DefaultRepositoryInitializationCallback implements InitializeRepositoriesCallback {
		private InitializeRepositoriesCallback callback;

		private DefaultRepositoryInitializationCallback(InitializeRepositoriesCallback callback) {
			this.callback = callback;
		}

		@Override
		public void onRepositoryInitialized() {
			callback.onRepositoryInitialized();
		}

		@Override
		public void onRepositoryInitializationFailed() {
			callback.onRepositoryInitializationFailed();
		}
	}

	private boolean isUserSavedInSharedPreferences() {
		return sharedPreferences.contains(USER_ID_KEY);
	}
}
