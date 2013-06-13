package com.quiz.flag;

import android.app.Activity;
import android.content.SharedPreferences;

public class UserPreference {
  private static final String PREFS_NAME = "flag_quiz";
  private static final String SOUNDS_KEY = "sound_key";
  private SharedPreferences preference;
  private boolean isSoundsEnabled;

  public UserPreference(Activity activity) {
    preference = activity.getSharedPreferences(PREFS_NAME, 0);
    isSoundsEnabled = preference.getBoolean(SOUNDS_KEY, true);
  }

  public void savePreference() {
    SharedPreferences.Editor editor = preference.edit();
    editor.putBoolean(SOUNDS_KEY, isSoundsEnabled);
    editor.commit();
  }

  public boolean isSoundsEnabled() {
    return isSoundsEnabled;
  }

  public void setSoundsEnabled(boolean isSoundsEnabled) {
    this.isSoundsEnabled = isSoundsEnabled;
  }
}
