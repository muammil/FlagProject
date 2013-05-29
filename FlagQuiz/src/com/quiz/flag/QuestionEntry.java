package com.quiz.flag;

import java.util.List;
/**
*
* Name to flag question entry
* @author Muammil
*/

public class QuestionEntry {
  private final List<Countries> options;
  private final Countries answer;

  public QuestionEntry(List<Countries> options, Countries answer) {
    this.options = options;
    this.answer = answer;
  }

  public List<Countries> getOptions() {
    return options;
  }

  public Countries getAnswer() {
    return answer;
  }
}
