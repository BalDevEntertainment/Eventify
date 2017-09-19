package com.baldev.eventify.presentation.createuser;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.baldev.eventify.R;
import com.baldev.eventify.dependencyinjection.ActionsFactory;
import com.baldev.eventify.dependencyinjection.FactoryProvider;
import com.baldev.eventify.dependencyinjection.PresenterFactory;
import com.baldev.eventify.presentation.createuser.CreateUserContract.Presenter;
import com.baldev.eventify.presentation.mainactivity.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateUserActivity extends AppCompatActivity implements CreateUserContract.View {

	@BindView(R.id.username_input)
	protected EditText usernameInput;

	@Inject
	private Presenter presenter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_create_user);
		ButterKnife.bind(this);
		this.presenter = FactoryProvider.presenterFactory().provideCreateUserPresenter(this);
	}

	@OnClick(R.id.accept_button)
	protected void onAcceptPressed() {
		this.presenter.acceptButtonPressed();
	}

	@Override
	public String getUserName() {
		return usernameInput.getText().toString();
	}

	@Override
	public void startMainActivity() {
		Intent intent = new Intent(this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		startActivity(intent);
	}

	@Override
	public void saveUserIdLocallyOnPhone() {
		SharedPreferences sharedPref = this.getSharedPreferences("User", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString("MyUserId", FactoryProvider.actionsFactory().provideGetMyUser().execute().getId());
		editor.commit();
	}
}
