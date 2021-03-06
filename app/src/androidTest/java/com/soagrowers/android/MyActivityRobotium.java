package com.soagrowers.android;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import junit.framework.Assert;

public class MyActivityRobotium extends ActivityInstrumentationTestCase2<MyActivity> {

  Solo solo;

  public MyActivityRobotium() {
    super(MyActivity.class);
  }

  @Override
  public void setUp() throws Exception {
    solo = new Solo(getInstrumentation(), getActivity());
  }

  @Override
  public void tearDown() throws Exception {
    solo.finishOpenedActivities();
  }

  public void testMyActivityWithRobotium() throws InterruptedException {
    // check that we have the right mActivity
    solo.assertCurrentActivity("wrong mActivity", MyActivity.class);

    //Test the 'Save' button, stores something.
    Assert.assertTrue(solo.waitForText(getActivity().getString(R.string.document_id)));
    solo.clickOnButton(solo.getString(R.string.save));
    Assert.assertTrue(solo.searchText("ID:"));
    Assert.assertFalse(solo.searchText("null"));
  }
}
