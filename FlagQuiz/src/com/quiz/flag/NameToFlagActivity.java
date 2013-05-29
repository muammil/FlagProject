package com.quiz.flag;

import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
/**
*
* Name to flag game mode
* @author Muammil
*/

public class NameToFlagActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.nametoflag_screen);
    QuestionGenerator generator = new QuestionGenerator();
    List<QuestionEntry> questions = generator.getQuestions();
    Countries answer = questions.get(0).getAnswer();
    TextView questionText = (TextView) findViewById(R.id.tv_n2f_nation);
    questionText.setText(answer.getName());
    List<Countries> options = questions.get(0).getOptions();
    CustomImageView[] flagOptions = new CustomImageView[4];
    flagOptions[0] = (CustomImageView) findViewById(R.id.iv_n2f_flag1);
    flagOptions[1] = (CustomImageView) findViewById(R.id.iv_n2f_flag2);
    flagOptions[2] = (CustomImageView) findViewById(R.id.iv_n2f_flag3);
    flagOptions[3] = (CustomImageView) findViewById(R.id.iv_n2f_flag4);
    int optionCount = 0;
    for(Countries option : options) {
      flagOptions[optionCount].setImageResource(option.getDrawableId());
      flagOptions[optionCount].setTag(option);
      addClickListener(flagOptions[optionCount], answer);
      ++optionCount;
    }
  }

  private void addClickListener(final CustomImageView option, final Countries answer) {
    final Countries selectedOption = (Countries)option.getTag();
    option.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {
        if(selectedOption == answer) {
          option.onClickImage(true, option.getWidth(), option.getHeight());
          option.setClickable(false);
        } else {
          option.onClickImage(false, option.getWidth(), option.getHeight());
          option.setClickable(false);
        }
      }
    });
  }
}
