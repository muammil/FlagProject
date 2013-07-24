package com.quiz.flag;

import com.quiz.flag.ReviewAdapter.RowType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
/**
*
* Header class for the question
* @author Muammil
*/

public class Header implements Item{
  private final Countries country;
  private final String questionNumber;

  public Header(String questionNumber, Countries country) {
    this.questionNumber = questionNumber;
    this.country = country;
  }

  @Override
  public int getViewType() {
    return RowType.HEADER_ITEM.ordinal();
  }

  @Override
  public View getView(LayoutInflater inflater, View convertView) {
    View view;
    if(convertView == null) {
      view = (View) inflater.inflate(R.layout.header, null);
    } else {
      view = convertView;
    }
    TextView question = (TextView) view.findViewById(R.id.tv_header_question);
    question.setText(questionNumber + country.getName());
    return view;
  }
}
