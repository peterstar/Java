package com.androidside.canvasdemob1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

public class SampleB1 extends Activity {
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
			
			Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
			canvas.drawBitmap(bitmap1, 0, 0, null);
			
			Bitmap bitmap2 = Bitmap.createScaledBitmap(bitmap1, 80, 20, false);
			for(int i=0; i<250; i+=25){
				canvas.drawBitmap(bitmap2, i, i+100, null);
			}
			
			bitmap1.recycle();
			bitmap2.recycle();
			
		}
	}
	

}