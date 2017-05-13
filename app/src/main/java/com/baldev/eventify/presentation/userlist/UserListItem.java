package com.baldev.eventify.presentation.userlist;

import com.baldev.eventify.domain.entities.User;
import com.google.common.base.Preconditions;

class UserListItem {
	private final User user;
	private boolean selected;

	public UserListItem(User user, boolean selected) {
		Preconditions.checkNotNull(user);
		this.user = user;
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setAsSelected() {
		this.selected = true;
	}

	public void setAsNotSelected() {
		this.selected = false;
	}

	public User getUser() {
		return user;
	}
}
