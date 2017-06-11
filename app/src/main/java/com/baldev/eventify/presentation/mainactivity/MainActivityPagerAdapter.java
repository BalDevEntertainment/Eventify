package com.baldev.eventify.presentation.mainactivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;


public class MainActivityPagerAdapter extends FragmentStatePagerAdapter {

	private final List<MainActivityPagerFragmentBuilder> fragmentBuilders;

	public MainActivityPagerAdapter(FragmentManager fm, List<MainActivityPagerFragmentBuilder> fragmentBuilders) {
		super(fm);
		this.fragmentBuilders = fragmentBuilders;
	}

	@Override
	public Fragment getItem(int i) {
		return fragmentBuilders.get(i).build();
	}

	@Override
	public int getCount() {
		return fragmentBuilders.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return fragmentBuilders.get(position).getPageTitle();
	}
}
