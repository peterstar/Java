package com.apps.lecture;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;

import com.example.apps.R;

public class NasaActivity extends Activity {
	WebView myWebview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.javabook_main);
		myWebview = (WebView)findViewById(R.id.webView1);
		myWebview.getSettings().setBuiltInZoomControls(true);
		myWebview.getSettings().setBuiltInZoomControls(true);
		myWebview.loadUrl("file:///android_asset/nasa.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nasa, menu);
		return true;
	}

}
