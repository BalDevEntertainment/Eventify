package com.baldev.eventify.presentation.mainactivity.events;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baldev.eventify.R;
import com.baldev.eventify.domain.entities.Event;
import com.baldev.eventify.presentation.mainactivity.events.EventListAdapter.EventViewHolder;

import java.util.List;

class EventListAdapter extends RecyclerView.Adapter<EventViewHolder> {

	private List<Event> items;

	public void setItems(List<Event> items) {
		this.items = items;
	}

	@Override
	public int getItemCount() {
		return items.size();
	}

	@Override
	public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new EventViewHolder(LayoutInflater.from(parent.getContext())
				.inflate(R.layout.list_item_event, parent, false));
	}

	@Override
	public void onBindViewHolder(EventViewHolder holder, int position) {
		Event event = items.get(position);
		holder.eventName.setText(event.getDescription());
	}

	public class EventViewHolder extends RecyclerView.ViewHolder {
		private final TextView eventName;

		public EventViewHolder(View itemView) {
			super(itemView);
			eventName = (TextView) itemView.findViewById(R.id.event_name_text);
		}
	}
}
