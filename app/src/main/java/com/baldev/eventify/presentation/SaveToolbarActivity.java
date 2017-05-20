package com.baldev.eventify.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.baldev.eventify.R;

public abstract class SaveToolbarActivity extends AppCompatActivity {
	private final SparseArrayCompat<SaveToolbarMenuAction> menuActionsMap = new SparseArrayCompat<>();

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return menuActionsMap.get(item.getItemId(), new TakeNoAction()).execute();
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupToolbar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_toolbar_save, menu);
		return true;
	}

	protected abstract void onSavePressed();

	protected void setupToolbar() {
		if (isToolbarSet()) {
			ActionBar actionBar = this.getSupportActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
			actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_close_clear_cancel);
			setActionBarActions();
		}
	}

	private void setActionBarActions() {
		menuActionsMap.put(R.id.action_menu_save, () -> {
			onSavePressed();
			return true;
		});
		menuActionsMap.put(android.R.id.home, () -> {
			this.finish();
			return true;
		});
	}

	private boolean isToolbarSet() {
		return this.getSupportActionBar() != null;
	}

	private class TakeNoAction implements SaveToolbarMenuAction {
		@Override
		public boolean execute() {
			return false;
		}
	}
}
