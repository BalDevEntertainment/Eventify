package com.baldev.eventify.domain.services;


import com.baldev.eventify.domain.actions.users.SaveUserCallback;
import com.baldev.eventify.domain.entities.UserCreationRequest;
import com.baldev.eventify.domain.repositories.UsersRepository;

public class SaveUserService {

	private UsersRepository usersRepository;

	public SaveUserService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public void saveUser(UserCreationRequest userCreationRequest, SaveUserCallback saveUserCallback) {
		usersRepository.saveUser(userCreationRequest, saveUserCallback);
	}
}
