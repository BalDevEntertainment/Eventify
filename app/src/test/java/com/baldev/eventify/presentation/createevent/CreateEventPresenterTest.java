package com.baldev.eventify.presentation.createevent;

import android.support.annotation.NonNull;

import com.baldev.eventify.domain.actions.SaveEvent;
import com.baldev.eventify.domain.actions.groups.GetMyGroups;
import com.baldev.eventify.domain.entities.Group;
import com.baldev.eventify.presentation.createevent.CreateEventContract.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anySetOf;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateEventPresenterTest {

	@Mock
	private GetMyGroups getMyGroups;
	@Mock
	private SaveEvent saveEvent;
	@Mock
	private View view;
	@Mock
	private Group group;

	@Mock
	private Date date;

	private String eventDescription = "Event Description";
	private String durationInHours = "1";
	private String groupName = "Group name";
	private Map<String, Group> groupNameMap = new HashMap<>();

	@Test(expected = NullPointerException.class)
	public void givenNullView_whenCreatePresenter_ThenThrowNullPointerException() {
		new CreateEventPresenter(null, getMyGroups, saveEvent);
	}

	@Before
	public void setUp() throws Exception {
		groupNameMap = new HashMap<>();
		groupNameMap.put(groupName, group);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullGetMyGroupsAction_whenCreatePresenter_ThenThrowNullPointerException() {
		new CreateEventPresenter(view, null, saveEvent);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullSaveEvent_whenCreatePresenter_ThenThrowNullPointerException() {
		new CreateEventPresenter(view, getMyGroups, null);
	}

	@Test()
	public void whenCreatePresenter_ThenReturnPresenter() {
		assertNotNull(buildPresenter());
	}

	@Test()
	public void whenCreatePresenter_ThenGetMyGroupsIsCalledOnce () {
		buildPresenter();
		verify(getMyGroups, times(1)).execute();
		verify(view, times(1)).setGroupListToSpinner(anySetOf(String.class));
	}

	@Test()
	public void whenSaveButtonIsPressed_ThenSaveIsExecutedOnce(){
		CreateEventPresenter presenter = buildPresenter();
		presenter.groupNameMap = groupNameMap;
		when(view.getSelectedGroupName()).thenReturn(groupName);
		when(view.getEventDescription()).thenReturn(eventDescription);
		when(view.getDate()).thenReturn(date);
		when(view.getDuration()).thenReturn(durationInHours);
		presenter.onSaveEventButtonPressed();
		verify(saveEvent, times(1)).execute(group, eventDescription, date, Integer.valueOf(durationInHours));
	}

	@NonNull
	private CreateEventPresenter buildPresenter() {
		return new CreateEventPresenter(view, getMyGroups, saveEvent);
	}
}