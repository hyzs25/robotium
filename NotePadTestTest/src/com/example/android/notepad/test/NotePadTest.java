package com.example.android.notepad.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.android.notepad.NotesList;
import com.jayway.android.robotium.solo.Solo;

import android.annotation.SuppressLint;
import android.provider.Telephony.Mms.Addr;
import android.test.ActivityInstrumentationTestCase2;

@SuppressLint("NewApi") public class NotePadTest extends ActivityInstrumentationTestCase2<NotesList> {
	
	private Solo solo;

	public NotePadTest(){
		super(NotesList.class);
	}

	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void tearDown() throws Exception{
		solo.finishOpenedActivities();
	}
	
	public void testAddNote() throws Exception{
		solo.clickOnMenuItem("Add note");
		solo.assertCurrentActivity("Expected NoteEditor activity", "NoteEditor");
		solo.enterText(0, "1");
		solo.goBack();
		solo.clickOnMenuItem("Add note");
		solo.enterText(0, "Note2");
		solo.goBackToActivity("NotesList");
		solo.takeScreenshot();
	}
	
}
