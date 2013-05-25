package com.quiz.flag;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
/**
*
* Count down screen shows just before the game starts.
* @author Muammil
*/

public class CountDownActivity extends Activity {
  private final long ONE_SECOND = 1000;
  private int count;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.count_down_screen);
    final TextView countDownText = (TextView) findViewById(R.id.tv_countdown);
    Intent getInteger = getIntent();
    final int key = getInteger.getExtras().getInt("key");
    count = 3;
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        runOnUiThread(new Runnable() {
          @Override
          public void run() {
            if(count > 0) {
              countDownText.setText(String.valueOf(count));
              --count;
            } else if(count == 0) {
              countDownText.setText("GO");
              Intent intent;
              switch(key) {
              case 0:
                intent = new Intent(CountDownActivity.this, NameToFlagActivity.class);
                startActivity(intent);
                break;
              case 1:
                intent = new Intent(CountDownActivity.this, FlagToNameActivity.class);
                startActivity(intent);
              }
              cancel();
            }
          }
        });
      }
    }, 0, ONE_SECOND);
  }

  @Override
  protected void onPause() {
    super.onPause();
    finish();
  }
}
