package com.baldev.eventify.presentation.mainactivity;

import com.baldev.eventify.domain.actions.groups.GetMyGroupsAction;
import com.baldev.eventify.presentation.mainactivity.MainActivityContract.View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

	@Mock
	private GetMyGroupsAction getMyGroupsAction;
	@Mock
	private View view;

	@Test(expected = NullPointerException.class)
	public void whenGetMyGroupsActionIsNullThrowNullPointerException () {
		buildPresenter(view, null);
	}

	@Test(expected = NullPointerException.class)
	public void whenViewIsNullThrowNullPointerException () {
		buildPresenter(null, getMyGroupsAction);
	}

	@Test()
	public void whenBuildPresenterThenInitializeGroupListAdapter () {
		MainActivityPresenter presenter = buildPresenter(view, getMyGroupsAction);
		verify(view, times(1)).setGroupListToAdapter(presenter.groups);
	}

	private MainActivityPresenter buildPresenter(View view, GetMyGroupsAction getMyGroupsAction) {
		return new MainActivityPresenter(view, getMyGroupsAction);
	}
}