package com.baldev.eventify.presentation.mainactivity;


import java.util.List;

public interface MainActivityContract {

	interface View {

		void collapseFabMenu();

		void startCreateGroupActivity();

		void startCreateEventActivity();

		void buildPagerAdapter(List<MainActivityPagerFragmentBuilder> adapter);
	}

	interface Presenter {

		void onCreateGroupPressed();

		void onCreateEventPressed();
	}
}
