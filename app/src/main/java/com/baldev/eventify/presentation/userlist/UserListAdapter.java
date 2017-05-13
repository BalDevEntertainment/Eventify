package com.baldev.eventify.presentation.userlist;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.baldev.eventify.R;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.presentation.userlist.UserListAdapter.UserViewHolder;

import java.util.ArrayList;
import java.util.List;

class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {

	private List<UserListItem> users = new ArrayList<>();

	public void setItems(List<UserListItem> items) {
		users = items;
	}

	@Override
	public int getItemCount() {
		return users.size();
	}

	@Override
	public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new UserViewHolder(LayoutInflater.from(parent.getContext())
				.inflate(R.layout.list_item_user, parent, false));
	}

	@Override
	public void onBindViewHolder(UserViewHolder holder, int position) {
		UserListItem userListItem = users.get(position);
		holder.userName.setText(userListItem.getUser().getName());
		holder.userSelectionCheckbox.setChecked(userListItem.isSelected());
		holder.userSelectionCheckbox
				.setOnCheckedChangeListener((compoundButton, checked) -> updateSelectionStatusForUserListItem(checked, position));
	}

	public List<User> getSelectedItems() {
		List<User> selectedUsers = new ArrayList<>();
		for (UserListItem userListItem : users) {
			if (userListItem.isSelected()) {
				selectedUsers.add(userListItem.getUser());
			}
		}
		return selectedUsers;
	}

	private void updateSelectionStatusForUserListItem(boolean checked, int position) {
		UserListItem userListItem = users.get(position);
		if (checked) {
			userListItem.setAsSelected();
		} else {
			userListItem.setAsNotSelected();
		}
	}

	public class UserViewHolder extends RecyclerView.ViewHolder {
		private final TextView userName;
		private final CheckBox userSelectionCheckbox;

		public UserViewHolder(View itemView) {
			super(itemView);
			userName = (TextView) itemView.findViewById(R.id.user_name_text);
			userSelectionCheckbox = (CheckBox) itemView.findViewById(R.id.user_selection_checkbox);
		}
	}
}
