package com.quiz.flag;

import android.app.Application;
/**
*
* Flag application class
* @author Muammil
*/

public class FlagApplication extends Application {
  private UserPreference userPreference;
  private SoundManager soundManager;

  public UserPreference getUserPreference() {
    return userPreference;
  }

  public void setUserPreference(UserPreference userPreference) {
    this.userPreference = userPreference;
  }

  public SoundManager getSoundManager() {
    return soundManager;
  }

  public void setSoundManager(SoundManager soundManager) {
    this.soundManager = soundManager;
  }
}
