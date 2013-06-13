package com.quiz.flag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;
/**
*
* Custom button class for drawing bitmap on buttons
* @author Muammil
*/

public class CustomButton extends Button {
  private static Bitmap thumpsUp;
  private static Bitmap thumpsDown;
  private boolean isSelected;
  private boolean isCorrect;
  private float xPos;
  private float yPos;

  public CustomButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    thumpsUp = BitmapFactory.decodeResource(getResources(), R.drawable.thumps_up_button);
    thumpsDown = BitmapFactory.decodeResource(getResources(), R.drawable.thumps_down_button);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if(isSelected) {
      if(isCorrect) {
        canvas.drawBitmap(thumpsUp, xPos/2 - thumpsUp.getWidth()/2, yPos/2 - thumpsUp.getHeight()/2, 
            null);
      } else {
        canvas.drawBitmap(thumpsDown, xPos/2 - thumpsDown.getWidth()/2, yPos/2 - thumpsDown.getHeight()/2, 
            null);
      }
    }
  }

  public void onClickButton(boolean isCorrect, float xPos, float yPos) {
    isSelected = true;
    this.isCorrect = isCorrect;
    this.xPos = xPos;
    this.yPos = yPos;
    invalidate();
  }

  public void clearSelection() {
    isSelected = false;
  }
}
