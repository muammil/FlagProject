package com.quiz.flag;

import com.quiz.flag.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FlagMainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.flag_main_screen);
    Button nameToFlag = (Button) findViewById(R.id.b_nametoflag);
    setButtonClickListener(nameToFlag);
    Button flagToName = (Button) findViewById(R.id.b_flagtoname);
    setButtonClickListener(flagToName);
    Button listFlags = (Button) findViewById(R.id.b_list);
    setButtonClickListener(listFlags);
    Button settings = (Button) findViewById(R.id.b_settings);
    setButtonClickListener(settings);
  }

  private void setButtonClickListener(Button button) {
    button.setOnClickListener(new  OnClickListener() {
      @Override public void onClick(View v) {
        switch(v.getId()) {
        case R.id.b_nametoflag :
          break;
        case R.id.b_flagtoname :
          break;
        case R.id.b_list :
          break;
        case R.id.b_settings :
          break;
	    }
	  }
    });
  }
}
