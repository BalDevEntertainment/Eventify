package com.baldev.eventify.presentation.mainactivity;

import android.support.v4.app.Fragment;

interface MainActivityPagerFragmentBuilder {
	Fragment build();

	String getPageTitle();
}
