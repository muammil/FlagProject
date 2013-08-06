package com.quiz.flag;

import java.io.Serializable;
/**
*
* Result tracker class
* @author Muammil
*/

public class ResultsTracker implements Serializable {
  private static final long serialVersionUID = 5814959493812694813L;
  private int correctCount;
  private int wrongCount;
  private int wrongTotal;
  private int correctTotal;
  private int total;

  public ResultsTracker() {
    correctCount = 0;
    wrongCount = 0;
    wrongTotal = 0;
    correctTotal = 0;
    total = 0;
  }

  public void countCorrect() {
    ++correctCount;
  }

  public void countWrong() {
    ++wrongCount;
  }

  public String getWrongTotal() {
    wrongTotal = 2 * wrongCount;
    return ""+wrongCount+" * 2 = "+wrongTotal;
  }

  public String getCorrectTotal() {
    correctTotal = 3 * correctCount;
    return ""+correctCount+" * 3 = "+correctTotal;
  }

  public String getTotalScore() {
    total = correctTotal - wrongTotal;
    return ""+correctTotal+" - "+wrongTotal+" = "+total;
  }
}
