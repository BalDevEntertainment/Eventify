package com.baldev.eventify.presentation.creategroup;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.presentation.creategroup.UserListAdapter.UserViewHolder;

import java.util.List;

class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {

	private List<User> items;

	public void setItems(List<User> items) {
		this.items = items;
	}

	@Override
	public int getItemCount() {
		return items.size();
	}

	@Override
	public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new UserViewHolder(LayoutInflater.from(parent.getContext())
				.inflate(android.R.layout.simple_list_item_1, parent, false));
	}

	@Override
	public void onBindViewHolder(UserViewHolder holder, int position) {
		holder.userName.setText(items.get(position).getName());
	}

	public class UserViewHolder extends RecyclerView.ViewHolder {
		private final TextView userName;

		public UserViewHolder(View itemView) {
			super(itemView);
			userName = (TextView)itemView.findViewById(android.R.id.text1);
		}
	}
}
