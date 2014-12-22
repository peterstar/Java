package com.apps.lecture;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apps.R;

public class MusicApp extends Activity implements View.OnClickListener {
	MediaPlayer player;
	
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	
	final String TAG = "MUSIC-APP";
	String[] url = {"http://developer.android.com/guide/topics/ui/controls/button.html",
			"http://spiritstoneswiki.com",
			"https://www.edx.org/",
			"http://yohan.net/"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.musicapp_main);
		Log.e(TAG, "onCreate");
		
		//player = MediaPlayer.create(this, R.raw.dont_call_me_darlin_copy);
				
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);
		button4 = (Button)findViewById(R.id.button4);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		
		TextView text = new TextView(this);		
		text.setText("Launch Web sites");
		/*
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url[0]));
				startActivity(i);
			}
		});
		*/
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.e(TAG, "onResume");		
		player = MediaPlayer.create(this, R.raw.i_will_survive);
		player.start();
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub		
		Log.e(TAG, "onPause");
		player.stop();
		player.release();
		super.onPause();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.e(TAG, "onDestroy");
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
		case R.id.button1:
			Log.e(TAG, "Button1");
			callIntent(url[0]);
			break;
		case R.id.button2:
			Log.e(TAG, "Button2");
			callIntent(url[1]);
			break;
		case R.id.button3:
			Log.e(TAG, "Button3");
			callIntent(url[2]);
			break;
		case R.id.button4:
			Log.e(TAG, "Button4");
			callIntent(url[3]);
			break;		
		}
	}
	
	public void callIntent(String url) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	}
}