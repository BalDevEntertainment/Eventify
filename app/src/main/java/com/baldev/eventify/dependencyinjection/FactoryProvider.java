package com.baldev.eventify.dependencyinjection;


import com.baldev.eventify.domain.repositories.FirebaseUserRepository;
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
			actionsFactory = new ActionsFactory(CacheGroupsRepository.getInstance(), FirebaseUserRepository.getInstance());
		}
		return actionsFactory;
	}
}
