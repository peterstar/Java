package com.apps.lecture;

import android.app.Activity;
import android.inputmethodservice.Keyboard.Key;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

import com.example.apps.R;

public class JavaBook extends Activity {
	WebView myWebview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.javabook_main);
		myWebview = (WebView)findViewById(R.id.webView1);
		myWebview.loadUrl("file:///android_asset/index.html");
				
		myWebview.getSettings().setBuiltInZoomControls(true);
		myWebview.getSettings().setJavaScriptEnabled(true);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if((keyCode==KeyEvent.KEYCODE_BACK)&&myWebview.canGoBack())
			return true;
		return super.onKeyDown(keyCode, event);
	}
}