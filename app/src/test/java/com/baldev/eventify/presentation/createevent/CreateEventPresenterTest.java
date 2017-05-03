package com.baldev.eventify.presentation.createevent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreateEventPresenterTest {

	@Test(expected = NullPointerException.class)
	public void givenNullView_ThenThrowNullPointerException() {
		new CreateEventPresenter(null);
	}
}
