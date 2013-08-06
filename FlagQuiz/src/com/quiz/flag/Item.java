package com.quiz.flag;

import android.view.LayoutInflater;
import android.view.View;
/**
*
* Interface for implementing header and choices
* @author Muammil
*/
public interface Item {

  public int getViewType();
  public View getView(LayoutInflater inflater, View convertView);

}
