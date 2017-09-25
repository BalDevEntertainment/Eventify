package com.baldev.eventify.dependencyinjection;


import com.baldev.eventify.infrastructure.repositories.FirebaseGroupRepository;
import com.baldev.eventify.infrastructure.repositories.FirebaseUserRepository;
import com.baldev.eventify.infrastructure.repositories.CacheGroupsRepository;

public abstract class FactoryProvider {

	private static PresenterFactory presenterFactory;
	private static ActionsFactory actionsFactory;

	public static PresenterFactory presenterFactory() {
		if (presenterFactory == null) {
			presenterFactory = new PresenterFactory(actionsFactory());
		}
		return presenterFactory;
	}

	public static ActionsFactory actionsFactory() {
		if (actionsFactory == null) {
			actionsFactory = new ActionsFactory(FirebaseGroupRepository.getInstance(), FirebaseUserRepository.getInstance());
		}
		return actionsFactory;
	}
}
