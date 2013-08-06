package com.quiz.flag;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
/**
*
* Name to flag game mode
* @author Muammil
*/

public class NameToFlagActivity extends Activity {
  private TextView questionText;
  private int questionId = 0;
  private CustomImageView[] flagOptions;
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
    setContentView(R.layout.nametoflag_screen);
    timer = new Timer();
    playSound = ((FlagApplication)getApplicationContext()).getSoundManager();
    items = new ArrayList<Item>();
    selectedChoices = new ArrayList<ListAnswerChoice>();
    QuestionGenerator generator = new QuestionGenerator();
    tracker = new ResultsTracker();
    questions = generator.getQuestions();
    questionLimit = questions.size();
    questionText = (TextView) findViewById(R.id.tv_n2f_nation);
    flagOptions = new CustomImageView[4];
    flagOptions[0] = (CustomImageView) findViewById(R.id.iv_n2f_flag1);
    flagOptions[1] = (CustomImageView) findViewById(R.id.iv_n2f_flag2);
    flagOptions[2] = (CustomImageView) findViewById(R.id.iv_n2f_flag3);
    flagOptions[3] = (CustomImageView) findViewById(R.id.iv_n2f_flag4);
    countDownText = (TextView) findViewById(R.id.tv_n2f_count);
    progress = (ProgressBar) findViewById(R.id.pb_n2f);
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
    Intent i = new Intent(NameToFlagActivity.this, GameEndActivity.class);
    i.putExtra("tracker", tracker);
    startActivity(i);
    finish();
  }

  private void showNextQuestion() {
    if (questionId == questionLimit) {
      onGameEnd();
    } else {
      Countries answer = questions.get(questionId).getAnswer();
      items.add(new Header("Q"+(questionId + 1)+" : ", answer));
      questionText.setText(answer.getName());
      List<Countries> options = questions.get(questionId).getOptions();
      for(Countries option : options) {
        selectedChoices.add(new ListAnswerChoice(option, null));
      }
      items.addAll(selectedChoices);
      int optionCount = 0;
      for(Countries option : options) {
        flagOptions[optionCount].setImageResource(option.getDrawableId());
        flagOptions[optionCount].setTag(option);
        addClickListener(flagOptions[optionCount], answer);
        ++optionCount;
      }
    }
  }

  private void addClickListener(final CustomImageView option, final Countries answer) {
    final Countries selectedOption = (Countries)option.getTag();
    option.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        ListAnswerChoice selectedChoice = null;
        for(ListAnswerChoice choice : selectedChoices) {
          if(choice.getCountry() == selectedOption) selectedChoice = choice;
        }
        if(selectedOption == answer) {
          tracker.countCorrect();
          option.onClickImage(true, option.getWidth(), option.getHeight());
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
          option.onClickImage(false, option.getWidth(), option.getHeight());
          playSound.wrong();
          selectedChoice.setStatus(false);
        }
        option.setClickable(false);
      }
    });
  }

  private void clearAllSlection() {
    for(int i = 0; i < 4; ++i) {
      flagOptions[i].clearSelection();
    }
  }

  @Override
  public void onBackPressed() {
    timer.cancel();
    finish();
  }
}
