package com.baldev.eventify.presentation.createevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.presentation.SaveToolbarActivity;
import com.baldev.eventify.presentation.createevent.CreateEventContract.Presenter;
import com.baldev.eventify.presentation.createevent.CreateEventContract.View;
import com.github.florent37.singledateandtimepicker.SingleDateAndTimePicker;

import java.util.Date;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CreateEventActivity extends SaveToolbarActivity implements View {

	@BindView(R.id.group_spinner)
	protected Spinner groupsSpinner;

	@BindView(R.id.event_description_input)
	protected EditText eventDescriptionInput;

	@BindView(R.id.duration_input)
	protected EditText durationInput;

	@BindView(R.id.date_time_picker)
	protected SingleDateAndTimePicker dateTimePicker;
	private Presenter presenter;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_event);
		ButterKnife.bind(this);
		presenter = PresenterFactory.provideCreateEventPresenter(this);
	}

	@Override
	public void setGroupListToSpinner(Set<String> groups) {
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
		adapter.addAll(groups);
		groupsSpinner.setAdapter(adapter);
	}

	@Override
	public String getSelectedGroupName() {
		return (String) groupsSpinner.getSelectedItem();
	}

	@Override
	public String getEventDescription() {
		return eventDescriptionInput.getText().toString();
	}

	@Override
	public Date getDate() {
		return dateTimePicker.getDate();
	}

	@Override
	public String getDuration() {
		return durationInput.getText().toString();
	}

	@Override
	public void finishActivity() {
		this.finish();
	}

	@Override
	protected void onSavePressed() {
		presenter.onSaveEventButtonPressed();
	}
}
