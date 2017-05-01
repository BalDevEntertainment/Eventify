package com.baldev.eventify.presentation.creategroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.Presenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateGroupActivity extends AppCompatActivity implements CreateGroupContract.View {

	@Inject
	private Presenter presenter;

	//@BindView(R.id.toolbar)
	//protected Toolbar toolbar;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_create_group);
		ButterKnife.bind(this);
		this.presenter = PresenterFactory.provideCreateGroupPresenter(this);
		setupToolbar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_create_group, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_menu_save:
				save();
				return true;
		}
		return false;
	}

	private void save() {

	}

	private void setupToolbar() {
		//setSupportActionBar(toolbar);
		if (isToolbarSet()) {
			this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			this.getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.ic_menu_close_clear_cancel);
		}
	}

	private boolean isToolbarSet() {
		return this.getSupportActionBar() != null;
	}
}
