package com.baldev.eventify.infrastructure.repositories;

import com.baldev.eventify.domain.actions.users.SaveUserCallback;
import com.baldev.eventify.domain.entities.User;
import com.baldev.eventify.domain.entities.UserCreationRequest;
import com.baldev.eventify.domain.exceptions.InvalidUserNameException;
import com.baldev.eventify.domain.repositories.GetUsersCallback;
import com.baldev.eventify.domain.repositories.UsersRepository;
import com.baldev.eventify.infrastructure.depdendencyinjection.RepositoriesFactory.InitializeRepositoriesCallback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseUserRepository implements UsersRepository {

	private static final String USERS_KEY = "users";
	private static final String ID_KEY = "id";
	private static UsersRepository instance;
	private DatabaseReference database;
	private User myUser;

	public static UsersRepository getInstance() {
		if (instance == null) {
			instance = new FirebaseUserRepository();
		}
		return instance;
	}

	private FirebaseUserRepository() {
		this.database = FirebaseDatabase.getInstance().getReference();
	}

	@Override
	public User getMyUser() {
		return myUser;
	}

	@Override
	public void saveUser(UserCreationRequest validUser, SaveUserCallback saveUserCallback) {
		String newUserId = database.child(USERS_KEY).push().getKey();
		try {
			User newUser = new User(newUserId, validUser.getName());
			database.child(USERS_KEY).child(newUser.getId()).setValue(newUser);
			myUser = newUser;
			saveUserCallback.onUserSaved();
		} catch (InvalidUserNameException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getUsers(GetUsersCallback getUsersCallback) {
		this.database.child(USERS_KEY).addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				List<User> users = new ArrayList<>();
				for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
					users.add(snapshot.getValue(User.class));
				}
				getUsersCallback.onUsersRetrieved(users);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
			}
		});
	}

	@Override
	public List<User> findUsers(String[] ids) {
		return null;
	}

	@Override
	public void initialize(String myUserId, InitializeRepositoriesCallback callback) {
		this.database.child(USERS_KEY).addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				myUser = getMyUser(dataSnapshot, myUserId);
				if (myUser != null) {
					callback.onRepositoryInitialized();
				} else {
					callback.onRepositoryInitializationFailed();
				}
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				callback.onRepositoryInitializationFailed();
			}
		});
	}

	private User getMyUser(DataSnapshot dataSnapshot, String myUserId) {
		for (DataSnapshot userDataSnapshot : dataSnapshot.getChildren()) {
			if (userDataSnapshot.hasChild(ID_KEY)) {
				if (userDataSnapshot.child(ID_KEY).getValue().equals(myUserId)) {
					return userDataSnapshot.getValue(User.class);
				}
			}
		}
		return null;
	}

}
