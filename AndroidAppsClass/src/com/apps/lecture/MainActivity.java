package com.apps.lecture;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.example.apps.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.e("Banana", "If music be the food of love");
		
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("sms:12345678")); 
		// same as Uri.fromParts("sms","123456",null)
		intent.putExtra("sms_body","My sms text message");
		
		
		Intent i = new Intent(Intent.ACTION_SENDTO);
		i.setData(Uri.fromParts("mailto","a@....",null));
		// set email subject line
		i.putExtra(Intent.EXTRA_SUBJECT, "Open Immediately - you've won a iPhone!");
		i.putExtra(Intent.EXTRA_TEXT, "Once upon a time"); // set email text
		
		if(intent.resolveActivity(getPackageManager()) == null) { 
			// program code			
		}
		
		// get app name string
		getString(R.string.app_name);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
