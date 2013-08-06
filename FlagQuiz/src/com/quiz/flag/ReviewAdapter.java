package com.quiz.flag;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
/**
*
* Adapter class for the list of items
* @author Muammil
*/

public class ReviewAdapter extends ArrayAdapter<Item>{
  private LayoutInflater mInflater;

  public ReviewAdapter(Context context, List<Item> items) {
    super(context, 0, items);
    mInflater = LayoutInflater.from(context);
  }

  public enum RowType {
    LIST_ITEM, HEADER_ITEM;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    return getItem(position).getView(mInflater, convertView);
  }

  @Override
  public int getItemViewType(int position) {
    return getItem(position).getViewType();
  }

  @Override
  public int getViewTypeCount() {
    return RowType.values().length;
  }
}
