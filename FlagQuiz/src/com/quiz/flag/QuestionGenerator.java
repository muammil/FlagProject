package com.quiz.flag;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
*
* Question Generator
* @author Muammil
*/

public class QuestionGenerator {
  private List<Countries> questionSet;

  public List<QuestionEntry> getQuestions() {
    List<QuestionEntry> questions = new ArrayList<QuestionEntry>();
    List<Countries> optionSet;

    for(int i= 0; i<=15; i++) {
      optionSet = getQuestionSet();
      questions.add(new QuestionEntry(optionSet, getAnswerFromSet(optionSet)));
    }
    return questions;
  }

  private List<Countries> getQuestionSet () {
    questionSet = new ArrayList<Countries>();
    for(int i=0; i<4; i++) {
      questionSet.add(Countries.getRandomCountry());
    }
    return questionSet;
  }

  private Countries getAnswerFromSet(List<Countries> optionSet) {
    Countries answer = optionSet.get(new Random().nextInt(optionSet.size()));
    return answer;
  }
}
