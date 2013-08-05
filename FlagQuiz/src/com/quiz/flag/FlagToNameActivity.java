package com.quiz.flag;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
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
  private ResultsTracker tracker;
  private List<Item> items;
  private List<ListAnswerChoice> selectedChoices;
  private Timer timer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.flagtoname_screen);
    timer = new Timer();
    playSound = ((FlagApplication)getApplicationContext()).getSoundManager();
    items = new ArrayList<Item>();
    selectedChoices = new ArrayList<ListAnswerChoice>();
    QuestionGenerator generator = new QuestionGenerator();
    tracker = new ResultsTracker();
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
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override public void run() {
        runOnUiThread(new Runnable() {
          @Override public void run() {
            if(count > 0) {
              countDownText.setText(String.valueOf(count));
              progress.setProgress(count);
              count--;
            } else if(count == 0) {
              onGameEnd();
              cancel();
            }
          }
        });
      }
    }, 0, ONE_SECOND);
  }

  private void onGameEnd() {
    ((FlagApplication)getApplicationContext()).setQuestionList(items);
    Intent i = new Intent(FlagToNameActivity.this, GameEndActivity.class);
    i.putExtra("tracker", tracker);
    startActivity(i);
    finish();
  }

  private void showNextQuestion() {
    if(questionId == questionLimit) {
      onGameEnd();
    } else {
      Countries answer = questions.get(questionId).getAnswer();
      items.add(new Header("Q"+(questionId + 1)+" : ", answer));
      questionFlag.setImageResource(answer.getDrawableId());
      List<Countries> options = questions.get(questionId).getOptions();
      for(Countries option : options) {
        selectedChoices.add(new ListAnswerChoice(option, null));
      }
      items.addAll(selectedChoices);
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
        ListAnswerChoice selectedChoice = null;
        for(ListAnswerChoice choice : selectedChoices) {
          if(choice.getCountry() == selectedOption) selectedChoice = choice;
        }
        if(selectedOption == answer) {
          tracker.countCorrect();
          option.onClickButton(true, option.getWidth(), option.getHeight());
          playSound.right();
          selectedChoice.setStatus(true);
          new Handler().postDelayed(new Runnable() {
            @Override public void run() {
              ++questionId;
              clearAllSlection();
              selectedChoices.clear();
              showNextQuestion();
            }
          }, 100);
        } else {
          tracker.countWrong();
          option.onClickButton(false, option.getWidth(), option.getHeight());
          playSound.wrong();
          selectedChoice.setStatus(false);
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

  @Override
  public void onBackPressed() {
    finish();
    timer.cancel();
  }

}
