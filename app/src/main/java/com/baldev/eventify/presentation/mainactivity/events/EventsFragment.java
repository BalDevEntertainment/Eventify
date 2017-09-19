package com.baldev.eventify.presentation.mainactivity.events;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.FactoryProvider;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.domain.entities.Event;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsFragment extends Fragment {

	public static final String title = "Events";

	private final EventListAdapter eventListAdapter = new EventListAdapter();

	@BindView(R.id.event_list)
	protected RecyclerView eventList;
	private EventsFragmentPresenter presenter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		presenter = FactoryProvider.presenterFactory().provideEventsFragmentPresenter(this);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_events, container, false);
		ButterKnife.bind(this, view);
		presenter.onViewCreated();
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		presenter.onResume();
	}

	public void setEventListToAdapter(List<Event> events) {
		this.eventList.setAdapter(eventListAdapter);
		this.eventList.setLayoutManager(new LinearLayoutManager(this.getActivity()));
		this.eventListAdapter.setItems(events);
		this.eventListAdapter.notifyDataSetChanged();
	}
}
