package com.baldev.eventify.domain.entities;


import com.google.common.base.Preconditions;

public class Group {
	private String name;

	public Group(String name) {
		Preconditions.checkNotNull(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
