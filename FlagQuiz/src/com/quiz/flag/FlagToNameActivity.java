package com.quiz.flag;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
/**
*
* Flag to name game mode
* @author Muammil
*/

public class FlagToNameActivity extends Activity {
  private ImageView questionFlag;
  private int questionId = 0;
  private CustomButton[] nationOptions;
  private List<QuestionEntry> questions;
  private int questionLimit;
  private TextView countDownText;
  private ProgressBar progress;
  private final long ONE_SECOND = 1000;
  private int count;
  private SoundManager playSound;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.flagtoname_screen);
    playSound = new SoundManager(getBaseContext());
    QuestionGenerator generator = new QuestionGenerator();
    questions = generator.getQuestions();
    questionLimit = questions.size();
    questionFlag = (ImageView) findViewById(R.id.iv_f2n_flag);
    nationOptions = new CustomButton[4];
    nationOptions[0] = (CustomButton) findViewById(R.id.b_f2n_nation1);
    nationOptions[1] = (CustomButton) findViewById(R.id.b_f2n_nation2);
    nationOptions[2] = (CustomButton) findViewById(R.id.b_f2n_nation3);
    nationOptions[3] = (CustomButton) findViewById(R.id.b_f2n_nation4);
    countDownText = (TextView) findViewById(R.id.tv_f2n_count);
    progress = (ProgressBar) findViewById(R.id.pb_f2n);
    count = 30;
    progress.setMax(count);
    showNextQuestion();
    new Timer().scheduleAtFixedRate(new TimerTask() {
      @Override public void run() {
        runOnUiThread(new Runnable() {
          @Override public void run() {
            if(count > 0) {
              countDownText.setText(String.valueOf(count));
              progress.setProgress(count);
              count--;
            } else if(count == 0) {
              finish();
              cancel();
            }
          }
        });
      }
    }, 0, ONE_SECOND);
  }

  private void showNextQuestion() {
    if(questionId == questionLimit) {
      finish();
    } else {
      Countries answer = questions.get(questionId).getAnswer();
      questionFlag.setImageResource(answer.getDrawableId());
      List<Countries> options = questions.get(questionId).getOptions();
      int optionsCount = 0;
      for(Countries option : options) {
        nationOptions[optionsCount].setText(option.getName());
        nationOptions[optionsCount].setTag(option);
        addClickListener(nationOptions[optionsCount], answer);
        ++optionsCount;
      }
    }
  }

  private void addClickListener(final CustomButton option, final Countries answer) {
    final Countries selectedOption = (Countries)option.getTag();
    option.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if(selectedOption == answer) {
          option.onClickButton(true, option.getWidth(), option.getHeight());
          playSound.right();
          new Handler().postDelayed(new Runnable() {
            @Override public void run() {
              ++questionId;
              clearAllSlection();
              showNextQuestion();
            }
          }, 100);
        } else {
          option.onClickButton(false, option.getWidth(), option.getHeight());
          playSound.wrong();
        }
        option.setClickable(false);
      }
    });
  }

  private void clearAllSlection() {
    for(int i = 0; i < 4; ++i) {
      nationOptions[i].clearSelection();
    }
  }
}
