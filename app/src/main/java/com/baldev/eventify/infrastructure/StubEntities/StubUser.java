package com.baldev.eventify.infrastructure.StubEntities;


import android.util.SparseArray;

import com.baldev.eventify.domain.entities.User;

import java.util.Random;

public class StubUser extends User {

	private static final SparseArray<String> names = new SparseArray<>();

	static {
		names.put(0, "Ariel");
		names.put(1, "Nicolas");
		names.put(2, "Joaquin");
		names.put(3, "Nacho");
		names.put(4, "Matias");
		names.put(5, "Pablo");
	}

	private static int getRandomId() {
		Random generator = new Random();
		return generator.nextInt(6);
	}

	public StubUser() {
		super(getRandomId(), names.get(getRandomId()));
	}
}
