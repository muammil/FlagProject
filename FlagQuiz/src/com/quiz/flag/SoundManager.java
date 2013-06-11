package com.quiz.flag;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
/**
*
* SoundManager class for all activities
* @author Muammil
*/

public class SoundManager {
  private final SoundPool soundPool;
  private final int right;
  private final int wrong;
  private boolean soundEnabled;
  /*SharedPreferences getPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
  boolean soundEnabled = getPref.getBoolean("checkbox", true); */

  public SoundManager(Context context) {
    soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
    right = soundPool.load(context, R.raw.right, 1);
    wrong = soundPool.load(context, R.raw.fail, 0);
  }

  public void right() {
    if(soundEnabled) soundPool.play(right, 1, 1, 0, 0, 1);
  }

  public void wrong() {
    if(soundEnabled) soundPool.play(wrong, 1, 1, 0, 0, 1);
  }

  public void setSoundStatus(boolean soundEnabled) {
    this.soundEnabled = soundEnabled;
  }
}
