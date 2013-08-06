package com.quiz.flag;

import java.util.ArrayList;
import java.util.List;
import android.app.Application;
/**
*
* Flag application class
* @author Muammil
*/

public class FlagApplication extends Application {
  private UserPreference userPreference;
  private SoundManager soundManager;
  private List<Item> questions = new ArrayList<Item>();

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

  public List<Item> getQuestionList() {
    return questions;
  }

  public void setQuestionList(List<Item> list) {
    this.questions = list;
  }

}
