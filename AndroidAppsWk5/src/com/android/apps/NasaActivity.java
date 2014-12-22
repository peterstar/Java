package com.android.apps;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;

public class NasaActivity extends Activity {
	WebView webview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nasa);
		webview = (WebView)findViewById(R.id.nasa_webview);
		webview.loadUrl("file:///android_asset/uofi-at-nasa.html");
		webview.getSettings().setBuiltInZoomControls(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nasa, menu);
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if((keyCode==KeyEvent.KEYCODE_BACK) && webview.canGoBack())
			return true;
		return super.onKeyDown(keyCode, event);
	}
}
