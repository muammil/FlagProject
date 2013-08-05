package com.quiz.flag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
*
* Question Generator
* @author Muammil
*/

public class QuestionGenerator {
  private final List<Countries> allCountries;

  public QuestionGenerator() {
    allCountries = Countries.getAllCountries();
  }

  public List<QuestionEntry> getQuestions() {
    List<QuestionEntry> questions = new ArrayList<QuestionEntry>();
    for(int i = 0; i < 35; i++) {
      List<Countries> optionSet = getOptions();
      questions.add(new QuestionEntry(optionSet, getAnswerFromSet(optionSet)));
    }
    return questions;
  }

  private List<Countries> getOptions() {
    List<Countries> shuffleList = new ArrayList<Countries>(allCountries);
    Collections.shuffle(shuffleList);
    return shuffleList.subList(0, 4);
  }

  private Countries getAnswerFromSet(List<Countries> optionSet) {
    return optionSet.get(new Random().nextInt(optionSet.size()));
  }
}
