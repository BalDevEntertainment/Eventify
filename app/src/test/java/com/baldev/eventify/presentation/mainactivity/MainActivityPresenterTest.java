package com.baldev.eventify.presentation.mainactivity;

import com.baldev.eventify.domain.actions.groups.GetMyGroupsAction;
import com.baldev.eventify.presentation.mainactivity.MainActivityContract.View;

import org.junit.Before;
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
	private MainActivityPresenter presenter;

	@Before
	public void setUp() throws Exception {
		presenter = buildPresenter(view, getMyGroupsAction);
	}

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
		verify(view, times(1)).setGroupListToAdapter(presenter.groups);
	}

	@Test
	public void whenCreateGroupPressed_ThenCollapseFabAndChangeStartCreateGroupActivity(){
		presenter.onCreateGroupPressed();
		verify(view, times(1)).collapseFabMenu();
		verify(view, times(1)).startCreateGroupActivity();
	}

	private MainActivityPresenter buildPresenter(View view, GetMyGroupsAction getMyGroupsAction) {
		return new MainActivityPresenter(view, getMyGroupsAction);
	}
}