package com.baldev.eventify.presentation.createuser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.PresenterFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateUserActivity extends AppCompatActivity implements CreateUserContract.View {

	@BindView(R.id.username_input)
	protected EditText usernameInput;

	@Inject
	private CreateUserPresenter presenter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_create_user);
		ButterKnife.bind(this);
		this.presenter = PresenterFactory.provideCreateUserPresenter(this);
	}

	@OnClick(R.id.accept_button)
	protected void onAcceptPressed() {
		this.presenter.acceptButtonPressed();
	}

	@Override
	public String getUserName() {
		return usernameInput.getText().toString();
	}
}
