package com.baldev.eventify.presentation.creategroup;

import com.baldev.eventify.domain.actions.groups.CreateGroupAction;
import com.baldev.eventify.domain.actions.users.FindUsersAction;
import com.baldev.eventify.domain.actions.users.GetMyUserAction;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.Presenter;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CreateGroupPresenter implements Presenter {

	protected final List<User> users = new ArrayList<>();
	private final GetMyUserAction getMyUserAction;
	private final CreateGroupAction createGroupAction;
	private FindUsersAction findUsersAction;
	private View view;

	@Inject
	public CreateGroupPresenter(View view, CreateGroupAction createGroupAction,
								GetMyUserAction getMyUserAction, FindUsersAction findUsersAction) {
		new CreateGroupPresenterValidations(view, createGroupAction, getMyUserAction).execute();
		this.getMyUserAction = getMyUserAction;
		this.createGroupAction = createGroupAction;
		this.findUsersAction = findUsersAction;
		this.view = view;
		initializeUsersList();
		initializeUserListAdapter();
	}

	@Override
	public void onSavePressed(String groupName) {
		try {
			createGroupAction.execute(getMyUserAction.execute().getId(), groupName, users);
			view.finishActivity();
		} catch (InvalidGroupNameException e) {
			view.showInvalidGroupNameError();
		}
	}

	@Override
	public void onSelectedUsersRetrieved(int[] userIds) {
		initializeUsersList();
		users.addAll(findUsersAction.execute(userIds));
		initializeUserListAdapter();
	}

	private void initializeUserListAdapter() {
		view.setUserListToAdapter(users);
	}

	private void initializeUsersList() {
		users.clear();
		users.add(getMyUserAction.execute());
	}
}
