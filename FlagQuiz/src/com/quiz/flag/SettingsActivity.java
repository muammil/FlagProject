package com.quiz.flag;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
/**
*
* Game Settings
* @author Muammil
*/

public class SettingsActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.settings_screen);
    final UserPreference preference = ((FlagApplication)getApplicationContext()).getUserPreference();
    CheckBox checkBoxSound = (CheckBox)findViewById(R.id.cb_sound);
    checkBoxSound.setChecked(preference.isSoundsEnabled());
    checkBoxSound.setOnCheckedChangeListener(new OnCheckedChangeListener() {
      @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        preference.setSoundsEnabled(isChecked);
      }
    });
  }
}
