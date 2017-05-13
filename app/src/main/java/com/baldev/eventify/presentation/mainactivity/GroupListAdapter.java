package com.baldev.eventify.presentation.mainactivity;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.presentation.mainactivity.GroupListAdapter.GroupViewHolder;

import java.util.List;

class GroupListAdapter extends RecyclerView.Adapter<GroupViewHolder> {

	private List<Group> items;

	public void setItems(List<Group> items) {
		this.items = items;
	}

	@Override
	public int getItemCount() {
		return items.size();
	}

	@Override
	public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new GroupViewHolder(LayoutInflater.from(parent.getContext())
				.inflate(android.R.layout.simple_list_item_1, parent, false));
	}

	@Override
	public void onBindViewHolder(GroupViewHolder holder, int position) {
		Group group = items.get(position);
		holder.groupName.setText(group.getName() + " " + String.valueOf(group.getUsers().size()));
	}

	public class GroupViewHolder extends RecyclerView.ViewHolder {
		private final TextView groupName;

		public GroupViewHolder(View itemView) {
			super(itemView);
			groupName = (TextView)itemView.findViewById(android.R.id.text1);
		}
	}
}
