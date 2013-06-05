package com.quiz.flag.test;

import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import junit.framework.AssertionFailedError;

import com.bitbar.recorder.extensions.ExtSolo;

import android.widget.Button;

public class FlagMainActivityTest extends ActivityInstrumentationTestCase2<Activity> {

  private static final String LAUNCHER_ACTIVITY_CLASSNAME = "com.quiz.flag.FlagMainActivity";
  private static Class<?> launchActivityClass;
  static {
    try {
      launchActivityClass = Class.forName(LAUNCHER_ACTIVITY_CLASSNAME);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  private ExtSolo solo; // ExtSolo is an extension of Robotium Solo that helps collecting better test execution data during test runs

  @SuppressWarnings("unchecked")
  public FlagMainActivityTest() {
    super((Class<Activity>) launchActivityClass);
  }

  @Override
  public void setUp() throws Exception {
    super.setUp();
    solo =
        new ExtSolo(getInstrumentation(), getActivity(), this.getClass().getCanonicalName(),
            getName());
  }

  @Override
  public void tearDown() throws Exception {
    solo.finishOpenedActivities();
    solo.tearDown();
    super.tearDown();
  }

  public void testRecorded() throws Exception {
    try {
      solo.waitForActivity("FlagMainActivity");
      solo.sleep(6200);
      assertTrue("Wait for button (id: com.quiz.flag.R.id.b_flagtoname) failed.",
          solo.waitForButtonById("com.quiz.flag.R.id.b_flagtoname", 20000));
      solo.clickOnButton((Button) solo.findViewById("com.quiz.flag.R.id.b_flagtoname"));
      solo.waitForActivity("CountDownActivity");
      solo.waitForActivity("FlagToNameActivity");
      solo.sleep(5900);
      assertTrue("Wait for button (id: com.quiz.flag.R.id.b_f2n_nation2) failed.",
          solo.waitForButtonById("com.quiz.flag.R.id.b_f2n_nation2", 20000));
      solo.clickOnButton((Button) solo.findViewById("com.quiz.flag.R.id.b_f2n_nation2"));
      solo.waitForActivity("FlagMainActivity");
    } catch (AssertionFailedError e) {
      solo.fail("com.quiz.flag.test.FlagMainActivityTest.testRecorded_scr_fail", e);
      throw e;
    } catch (Exception e) {
      solo.fail("com.quiz.flag.test.FlagMainActivityTest.testRecorded_scr_fail", e);
      throw e;
    }
  }

}
