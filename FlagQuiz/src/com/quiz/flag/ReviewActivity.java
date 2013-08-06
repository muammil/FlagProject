package com.quiz.flag;

import java.util.List;
import android.app.ListActivity;
import android.os.Bundle;
/**
*
* Review activity
* @author Muammil
*/

public class ReviewActivity extends ListActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.review_list);
    List<Item> items = ((FlagApplication)getApplicationContext()).getQuestionList();
    ReviewAdapter adapter = new ReviewAdapter(this, items);
    setListAdapter(adapter);
  }
}
