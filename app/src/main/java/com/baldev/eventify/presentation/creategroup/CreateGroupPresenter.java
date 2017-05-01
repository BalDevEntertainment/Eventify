package com.baldev.eventify.presentation.creategroup;

import com.baldev.eventify.domain.actions.CreateGroupAction;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.services.GetMyUserService;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.Presenter;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.View;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CreateGroupPresenter implements Presenter {

	private final List<User> users;
	private final GetMyUserService getMyUserService;

	@Inject
	public CreateGroupPresenter(View view, CreateGroupAction createGroupAction, GetMyUserService getMyUserService) {
		new Validations(view, createGroupAction, getMyUserService).execute();
		this.getMyUserService = getMyUserService;
		users = initializeUsersList();

		initializeUserListAdapter(view);
	}

	public List<User> getUserList() {
		return users;
	}

	private void initializeUserListAdapter(View view) {
		view.setUserListToAdapter(users);
	}

	private List<User> initializeUsersList() {
		List<User> users = new ArrayList<>();
		users.add(getMyUserService.getMyUser());
		return users;
	}

	private class Validations {
		private View view;
		private CreateGroupAction createGroupAction;
		private GetMyUserService getMyUserService;

		public Validations(View view, CreateGroupAction createGroupAction, GetMyUserService getMyUserService) {
			this.view = view;
			this.createGroupAction = createGroupAction;
			this.getMyUserService = getMyUserService;
		}

		public void execute() {
			Preconditions.checkNotNull(view);
			Preconditions.checkNotNull(createGroupAction);
			Preconditions.checkNotNull(getMyUserService);
		}
	}
}
