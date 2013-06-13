package com.quiz.flag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
/**
*
* Game end screen
* @author Muammil
*/

public class GameEndActivity extends Activity {
  private ResultsTracker tracker;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.game_end_screen);
    Button menu = (Button) findViewById(R.id.b_end_menu);
    setButtonClickListener(menu);
    Button review = (Button) findViewById(R.id.b_end_review);
    setButtonClickListener(review);
    tracker = (ResultsTracker) getIntent().getSerializableExtra("tracker");
    TextView correct = (TextView) findViewById(R.id.tv_end_correct);
    TextView wrong = (TextView) findViewById(R.id.tv_end_wrong);
    TextView total = (TextView) findViewById(R.id.tv_end_total);
    correct.setText(tracker.getCorrectTotal());
    wrong.setText(tracker.getWrongTotal());
    total.setText(tracker.getTotalScore());
  }

  private void setButtonClickListener(Button button) {
    button.setOnClickListener(new OnClickListener() {
      @Override public void onClick(View v) {
        switch(v.getId()) {
        case R.id.b_end_menu:
          startActivity(new Intent(GameEndActivity.this, FlagMainActivity.class));
          finish();
          break;
        case R.id.b_end_review:
          //TODO: Review
          break;
        }
      }
    });
  }
}
