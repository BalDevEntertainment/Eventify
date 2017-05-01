package com.baldev.eventify.presentation.creategroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.presentation.creategroup.CreateGroupContract.Presenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class CreateGroupActivity extends AppCompatActivity implements CreateGroupContract.View {

	private final SparseArrayCompat<CreateGroupMenuAction> menuActionsMap = new SparseArrayCompat<>();

	@Inject
	private Presenter presenter;

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
		return menuActionsMap.get(item.getItemId(), new TakeNoAction()).execute();
	}

	private void save() {

	}

	private void setupToolbar() {
		if (isToolbarSet()) {
			ActionBar actionBar = this.getSupportActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
			actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_close_clear_cancel);
			setActionBarActions();
		}
	}

	private void setActionBarActions() {
		menuActionsMap.put(R.id.action_menu_save, () -> {
			save();
			return true;
		});
	}

	private boolean isToolbarSet() {
		return this.getSupportActionBar() != null;
	}

	private class TakeNoAction implements CreateGroupMenuAction {
		@Override
		public boolean execute() {
			return false;
		}
	}
}
