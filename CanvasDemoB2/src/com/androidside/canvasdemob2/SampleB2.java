package com.androidside.canvasdemob2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

public class SampleB2 extends Activity {
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
			
			String filePath = Environment.getExternalStorageDirectory() + "/pic.jpg";
			Bitmap bitmap = BitmapFactory.decodeFile(filePath);
			canvas.drawBitmap(bitmap, 0, 0, null);
			bitmap.recycle();
		}
	}
}