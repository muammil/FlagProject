package com.quiz.flag;

import com.quiz.flag.ReviewAdapter.RowType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/**
*
* Answer row class
* @author Muammil
*/

public class ListAnswerChoice implements Item {
  private final Countries country;
  private Boolean status;

  public ListAnswerChoice(Countries country, Boolean status) {
    this.country = country;
    this.status = status;
  }

  @Override
  public int getViewType() {
    return RowType.LIST_ITEM.ordinal();
  }

  @Override
  public View getView(LayoutInflater inflater, View convertView) {
    View view;
    if(convertView == null) {
      view = (View) inflater.inflate(R.layout.flag_image_row, null);
    } else {
      view = convertView;
    }
    ImageView countryFlag = (ImageView) view.findViewById(R.id.iv_row_flag);
    TextView countryName = (TextView) view.findViewById(R.id.tv_row_text);
    ImageView statusView = (ImageView) view.findViewById(R.id.iv_row_status);
    countryFlag.setImageResource(country.getDrawableId());
    countryName.setText(country.getName());
    if(status == null) {
      statusView.setImageDrawable(null);
    } else {
       if(status) {
         statusView.setImageResource(R.drawable.thumps_up_button);
       } else {
         statusView.setImageResource(R.drawable.thumps_down_button);
       }
    }
    return view;
  }

  public Countries getCountry() {
    return country;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}
