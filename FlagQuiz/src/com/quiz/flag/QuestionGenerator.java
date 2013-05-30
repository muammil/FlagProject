package com.quiz.flag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
*
* Question Generator
* @author Muammil
*/

public class QuestionGenerator {

  public List<QuestionEntry> getQuestions() {
    List<QuestionEntry> questions = new ArrayList<QuestionEntry>();

    List<Countries> questionSet1 = new ArrayList<Countries> (Arrays.asList(Countries.ANDORRA,
        Countries.ARMENIA, Countries.CAMERON,Countries.WALES));
    questions.add(new QuestionEntry(questionSet1, Countries.CAMERON));

    List<Countries> questionSet2 = new ArrayList<Countries> (Arrays.asList(Countries.COLOMBIA,
        Countries.CHILE,Countries.VENEZUELA,Countries.DENMARK));
    questions.add(new QuestionEntry(questionSet2, Countries.CHILE));

    List<Countries> questionSet3 = new ArrayList<Countries> (Arrays.asList(Countries.ARGENTINA,
        Countries.SANMARINO, Countries.INDONESIA, Countries.ZIMBABWE));
    questions.add(new QuestionEntry(questionSet3, Countries.SANMARINO));

    List<Countries> questionSet4 = new ArrayList<Countries> (Arrays.asList(Countries.BANGLADESH,
        Countries.PAKISTAN, Countries.ESTONIA, Countries.UKRAIN));
    questions.add(new QuestionEntry(questionSet4, Countries.PAKISTAN));

    List<Countries> questionSet5 = new ArrayList<Countries> (Arrays.asList(Countries.HAITI,
        Countries.UGANDA, Countries.TRINIDAD, Countries.SUDAN));
    questions.add(new QuestionEntry(questionSet5, Countries.TRINIDAD));

    List<Countries> questionSet6 = new ArrayList<Countries> (Arrays.asList(Countries.ITALY,
        Countries.HUNGARY, Countries.INDIA, Countries.IRELAND));
    questions.add(new QuestionEntry(questionSet6, Countries.INDIA));

    List<Countries> questionSet7 = new ArrayList<Countries>( Arrays.asList(Countries.ARMENIA,
        Countries.CZECH, Countries.TANZANIA, Countries.YEMEN));
    questions.add(new QuestionEntry(questionSet7, Countries.CZECH));

    List<Countries> questionSet8 = new ArrayList<Countries> (Arrays.asList(Countries.FRANCE,
        Countries.SLOVENIA, Countries.SLOVAKIA, Countries.SERBIA));
    questions.add(new QuestionEntry(questionSet8, Countries.SLOVAKIA));

    List<Countries> questionSet9 = new ArrayList<Countries> (Arrays.asList(Countries.SOUTHKOREA,
        Countries.NETHERLANDS, Countries.LUXEMBOURG, Countries.PANAMA));
    questions.add(new QuestionEntry(questionSet9, Countries.NETHERLANDS));

    List<Countries> questionSet10 = new ArrayList<Countries> (Arrays.asList(Countries.INDONESIA,
        Countries.USA, Countries.BRITAIN, Countries.GUINEA));
    questions.add(new QuestionEntry(questionSet10, Countries.BRITAIN));

    return questions;
  }
}
