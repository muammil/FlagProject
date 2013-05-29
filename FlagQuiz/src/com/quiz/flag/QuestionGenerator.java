package com.quiz.flag;

import java.util.ArrayList;
import java.util.List;
/**
*
* Name to flag questions
* @author Muammil
*/

public class QuestionGenerator {

  public List<QuestionEntry> getQuestions() {
    List<QuestionEntry> questions = new ArrayList<QuestionEntry>();
    List<Countries> options = new ArrayList<Countries>();
    options.add(Countries.ANDORRA);
    options.add(Countries.ARGENTINA);
    options.add(Countries.ARMENIA);
    options.add(Countries.AZEBAIJAN);
    questions.add(new QuestionEntry(options, Countries.ANDORRA));
    return questions;
  }
}
