package com.baldev.eventify.presentation.createevent;

import android.support.annotation.NonNull;

import com.baldev.eventify.domain.actions.groups.GetMyGroups;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.presentation.createevent.CreateEventContract.View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CreateEventPresenterTest {

	@Mock
	private GetMyGroups getMyGroups;
	@Mock
	private View view;

	@Test(expected = NullPointerException.class)
	public void givenNullView_whenCreatePresenter_ThenThrowNullPointerException() {
		new CreateEventPresenter(null, getMyGroups);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullGetMyGroupsAction_whenCreatePresenter_ThenThrowNullPointerException() {
		new CreateEventPresenter(view, null);
	}

	@Test()
	public void whenCreatePresenter_ThenReturnPresenter() {
		assertNotNull(buildPresenter());
	}

	@Test()
	public void whenCreatePresenter_ThenGetMyGroupsIsCalledOnce () {
		buildPresenter();
		verify(getMyGroups, times(1)).execute();
		verify(view, times(1)).setGroupListToSpinner(anyListOf(Group.class));
	}

	@NonNull
	private CreateEventPresenter buildPresenter() {
		return new CreateEventPresenter(view, getMyGroups);
	}
}
