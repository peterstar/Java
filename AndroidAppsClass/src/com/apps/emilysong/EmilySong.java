package com.apps.emilysong;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.apps.R;

public class EmilySong extends Activity {
	MediaPlayer dontCallMe;
	String TAG ="EmilySong";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.e(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emily_main);
		
		//dontCallMe.start();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.e(TAG, "onResume");
		dontCallMe = MediaPlayer.create(this, R.raw.dont_call_me_darlin_copy);
		dontCallMe.start();
		super.onResume();		
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Log.e(TAG, "onPause");
		dontCallMe.stop();
		dontCallMe.release();
		super.onPause();		
	}
			
	public void openFB(View v) {
		String url = "https://www.facebook.com/emily.otnes.music";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	}
	
	public void openBC(View v) {
		String url = "http://emilyotnesmusic.bandcamp.com/track/dont-call-me-darlin";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	}
}