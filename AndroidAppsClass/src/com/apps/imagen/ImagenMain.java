package com.apps.imagen;

import com.example.apps.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ImagenMain extends Activity implements OnClickListener {
	
	private static final String KEY_COUNT = "count";
	private static final String TAG = ImagenMain.class.getSimpleName();
	private SharedPreferences mPref;
	private TextView mText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);			
		Log.d(TAG, "onCreate");
		mPref = getPreferences(MODE_PRIVATE);
		int count = mPref.getInt(KEY_COUNT, 0);		
		count = count + 1;
		Editor editor = mPref.edit();
		editor.putInt(KEY_COUNT, count);
		editor.commit();
		Log.d(TAG, "Count: " + count);
		
		mText = new TextView(this);
		mText.setTextSize(80);
		mText.setText(count);
		setContentView(mText);		
		
		mText.setOnClickListener(this);		
		//setContentView(R.layout.imagen_main);	
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int clickCount = 20 + mPref.getInt("clicked", 0);		
		mPref.edit().putInt("clicked", clickCount).putBoolean("user", true).commit();
		mText.setTextSize(40);
		mText.setTextColor(0xff00ff00);
		if(clickCount>200)
			mText.setTextColor(Color.BLUE);
		mText.append("Clicked count: " + clickCount);
	}
}