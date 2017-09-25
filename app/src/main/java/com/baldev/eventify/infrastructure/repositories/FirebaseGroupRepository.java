package com.baldev.eventify.infrastructure.repositories;


import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.exceptions.InvalidGroupNameException;
import com.baldev.eventify.domain.repositories.GroupsRepository;
import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory.InitializeRepositoriesCallback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseGroupRepository implements GroupsRepository {
	private static final String GROUPS_KEY = "groups";
	private static FirebaseGroupRepository instance;
	private final DatabaseReference database;
	private List<Group> groups = new ArrayList<>();

	protected FirebaseGroupRepository() throws InvalidGroupNameException {
		this.database = FirebaseDatabase.getInstance().getReference();
	}

	public static GroupsRepository getInstance() {
		if (instance == null) {
			try {
				instance = new FirebaseGroupRepository();
			} catch (InvalidGroupNameException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	@Override
	public void initialize(InitializeRepositoriesCallback callback) {
		this.database.child(GROUPS_KEY).addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				for (DataSnapshot userDataSnapshot : dataSnapshot.getChildren()) {
					Group group = userDataSnapshot.getValue(Group.class);
					groups.add(group);
				}
				callback.onRepositoryInitialized();
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				callback.onRepositoryInitializationFailed();
			}
		});
	}

	@Override
	public List<Group> getGroupsByUser(User user) {
		return groups;
	}

	@Override
	public Group createGroup(User user, String groupName, List<User> users) throws InvalidGroupNameException {
		String newGroupId = database.child(GROUPS_KEY).push().getKey();
		Group group = new Group(newGroupId, groupName, users);
		database.child(GROUPS_KEY).child(group.getId()).setValue(group);
		groups.add(group);
		return group;
	}
}
