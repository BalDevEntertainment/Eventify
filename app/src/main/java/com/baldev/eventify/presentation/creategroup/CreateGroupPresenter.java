package com.baldev.eventify.presentation.creategroup;

import com.baldev.eventify.domain.actions.CreateGroupAction;
import com.baldev.eventify.domain.actions.GetMyUserAction;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.Presenter;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CreateGroupPresenter implements Presenter {

	private final List<User> users;
	private final GetMyUserAction getMyUserAction;

	@Inject
	public CreateGroupPresenter(View view, CreateGroupAction createGroupAction, GetMyUserAction getMyUserAction) {
		new CreateGroupPresenterValidations(view, createGroupAction, getMyUserAction).execute();
		this.getMyUserAction = getMyUserAction;
		this.users = initializeUsersList();

		initializeUserListAdapter(view);
		createGroupAction.execute(users);
	}

	public List<User> getUserList() {
		return users;
	}

	private void initializeUserListAdapter(View view) {
		view.setUserListToAdapter(users);
	}

	private List<User> initializeUsersList() {
		List<User> users = new ArrayList<>();
		users.add(getMyUserAction.execute());
		return users;
	}
}
