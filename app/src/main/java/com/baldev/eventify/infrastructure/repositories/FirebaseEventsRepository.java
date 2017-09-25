package com.baldev.eventify.infrastructure.repositories;


import com.baldev.eventify.domain.entities.Event;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.repositories.EventsRepository;
import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory.InitializeRepositoriesCallback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.google.common.base.Optional.fromNullable;

public class FirebaseEventsRepository implements EventsRepository {
	private static final String EVENTS_KEY = "events";
	private static EventsRepository instance;
	private DatabaseReference database;
	private List<Event> events = new ArrayList<>();

	public static EventsRepository getInstance() {
		return fromNullable(instance).or(() -> {
			instance = new FirebaseEventsRepository();
			return instance;
		});
	}

	private FirebaseEventsRepository() {
		this.database = FirebaseDatabase.getInstance().getReference();
	}

	@Override
	public Event saveEvent(Group group, String description, Date date, int duration) {
		String newEventId = database.child(EVENTS_KEY).push().getKey();
		Event event = new Event(newEventId, group, description, date, duration);
		database.child(EVENTS_KEY).child(event.getId()).setValue(event);
		events.add(event);
		return event;
	}

	@Override
	public List<Event> getEventsByUserId(String id) {
		return events;
	}

	@Override
	public void initialize(InitializeRepositoriesCallback callback) {
		this.database.child(EVENTS_KEY).addListenerForSingleValueEvent(new ValueEventListener() {
			public void onDataChange(DataSnapshot dataSnapshot) {
				for (DataSnapshot userDataSnapshot : dataSnapshot.getChildren()) {
					Event event = userDataSnapshot.getValue(Event.class);
					events.add(event);
				}
				callback.onRepositoryInitialized();
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				callback.onRepositoryInitializationFailed();
			}
		});
	}
}
