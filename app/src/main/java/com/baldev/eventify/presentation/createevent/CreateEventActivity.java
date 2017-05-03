package com.baldev.eventify.presentation.createevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.baldev.eventify.R;
import com.baldev.eventify.presentation.createevent.CreateEventContract.View;

import butterknife.ButterKnife;


class CreateEventActivity extends AppCompatActivity implements View {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ButterKnife.bind(this);
		setContentView(R.layout.activity_create_event);

	}
}
