package com.example.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class MultiTouchMain extends Activity {
	TextView pointerText1;
	TextView pointerText2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		pointerText1 = (TextView)findViewById(android.R.id.text1);
		pointerText2 = (TextView)findViewById(android.R.id.text2);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		// if >1, then multi-touch event
		int pointCount = event.getPointerCount();
		
		if(event.getAction() != MotionEvent.ACTION_UP){
			if(pointCount == 1){
				pointerText1.setText(" "+ event.getX(0) + event.getY(0));
			} else if(pointCount == 2){
				String text = " " + event.getX(0) + event.getY(0) + 
						event.getX(1) + event.getY(1);
				pointerText2.setText(text);
			}
		}
		
		
		return super.onTouchEvent(event);
	}
}