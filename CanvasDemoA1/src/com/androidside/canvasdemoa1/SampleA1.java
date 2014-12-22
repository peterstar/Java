package com.androidside.canvasdemoa1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class SampleA1 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}

	public static class MyView extends View {
		MyView(Context c){
			super(c);
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			super.onDraw(canvas);
			
			Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
			
			paint.setColor(Color.WHITE);
			
			paint.setStyle(Style.FILL);
			canvas.drawRect(10, 10, 10+100, 10+100, paint);
			
			paint.setStyle(Style.STROKE);
			canvas.drawRect(120, 10, 120+100, 10+100, paint);
			
			paint.setStyle(Style.FILL);
			RectF rectF1 = new RectF(10, 120, 10+100, 120+100);
			canvas.drawRoundRect(rectF1, 10, 10, paint);
			
			paint.setStyle(Style.STROKE);
			RectF rectF2 = new RectF(120, 120, 120+100, 120+100);
			canvas.drawRoundRect(rectF2, 10, 10, paint);
			
			paint.setStyle(Style.FILL);
			canvas.drawCircle(60, 280, 50, paint);
			
			paint.setStyle(Style.STROKE);
			canvas.drawCircle(120, 280, 50, paint);
			
		}
	}
}