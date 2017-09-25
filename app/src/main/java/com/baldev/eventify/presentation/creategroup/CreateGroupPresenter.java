package com.baldev.eventify.presentation.creategroup;

import com.baldev.eventify.domain.actions.groups.CreateGroup;
import com.baldev.eventify.domain.actions.users.GetMyUser;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.Presenter;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CreateGroupPresenter implements Presenter {

	protected final List<User> users = new ArrayList<>();
	private final GetMyUser getMyUser;
	private final CreateGroup createGroup;
	private View view;

	@Inject
	public CreateGroupPresenter(View view, CreateGroup createGroup,
								GetMyUser getMyUser) {
		new CreateGroupPresenterValidations(view, createGroup, getMyUser).execute();
		this.getMyUser = getMyUser;
		this.createGroup = createGroup;
		this.view = view;
		initializeUsersList(users);
		initializeUserListAdapter();
	}

	@Override
	public void onSavePressed(String groupName) {
		try {
			createGroup.execute(getMyUser.execute(), groupName, users);
			view.finishActivity();
		} catch (InvalidGroupNameException e) {
			view.showInvalidGroupNameError();
		}
	}

	@Override
	public void onSelectedUsersRetrieved(List<User> users) {
		initializeUsersList(users);
		initializeUserListAdapter();
	}

	@Override
	public void onAddRemoveMemberButtonPressed() {
		view.startUserListActivityForResult(users);
	}

	private void initializeUserListAdapter() {
		view.setUserListToAdapter(users);
	}

	private void initializeUsersList(List<User> newUsers) {
		this.users.clear();
		this.users.add(getMyUser.execute());
		this.users.addAll(newUsers);
	}
}
