package com.android.apps;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class JabberwockyActivity extends Activity {
	WebView jabber_webview;
	MediaPlayer player;
	Button picBtn, browserBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jabberwocky);		
		jabber_webview = (WebView)findViewById(R.id.jabber_webview);		
		jabber_webview.loadUrl("file:///android_asset/jabberwocky.html");
		jabber_webview.getSettings().setBuiltInZoomControls(true);
		
		picBtn = (Button)findViewById(R.id.picBtn);
		browserBtn = (Button)findViewById(R.id.browserBtn);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jabberwocky, menu);
		return true;
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		player = MediaPlayer.create(this, R.raw.harmonica);
		player.start();
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		player.stop();
		player.release();
		super.onPause();
	}
	
	public void openBrowser(View v) {
		String data = "http://en.wikipedia.org/wiki/Jabberwocky";
		Intent i = new Intent();
		i.setAction(Intent.ACTION_VIEW);
		i.setData(Uri.parse(data));
		startActivity(i);
	}
	
	public void openPicture(View v) {
		String data = "file:///android_asset/harmonica_1.jpg";
		jabber_webview.loadUrl(data);
	}

}
