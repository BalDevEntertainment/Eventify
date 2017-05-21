package com.baldev.eventify.presentation.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.presentation.createevent.CreateEventActivity;
import com.baldev.eventify.presentation.creategroup.CreateGroupActivity;
import com.baldev.eventify.presentation.mainactivity.MainActivityContract.Presenter;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

	@Inject
	private Presenter presenter;

	@BindView(R.id.pager)
	protected ViewPager viewPager;

	@BindView(R.id.tab_layout)
	protected TabLayout tabLayout;

	@BindView(R.id.fab_actions)
	protected FloatingActionsMenu fabMenu;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		this.presenter = PresenterFactory.provideMainActivityPresenter(this);
		tabLayout.setupWithViewPager(viewPager);
	}

	@Override
	public void collapseFabMenu() {
		fabMenu.collapse();
	}

	@Override
	public void startCreateGroupActivity() {
		Intent intent = new Intent(this, CreateGroupActivity.class);
		startActivity(intent);
	}

	@Override
	public void startCreateEventActivity() {
		Intent intent = new Intent(this, CreateEventActivity.class);
		startActivity(intent);
	}

	@Override
	public void buildPagerAdapter(List<MainActivityPagerFragmentBuilder> pagerFragments) {
		this.viewPager.setAdapter(new MainActivityPagerAdapter(this.getSupportFragmentManager(), pagerFragments));
	}

	@OnClick(R.id.create_group)
	public void onFabCreateGroupPressed() {
		presenter.onCreateGroupPressed();
	}

	@OnClick(R.id.create_event)
	public void onFabCreateEventPressed() {
		presenter.onCreateEventPressed();
	}
}
