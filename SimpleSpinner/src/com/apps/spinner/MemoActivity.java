package com.apps.spinner;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
 * Implements following Android ideas:
 * LinearLayout, ScrollView, TextView, EditText
 * Sharing Text, Preference, OnClickListener
 * 
 *  Enter memo and it is displayed in text view.
 *  All memo can be sent via SMS.
 *  
 */

public class MemoActivity extends Activity {

	private static final String TAG = MemoActivity.class.getSimpleName();
	
	SharedPreferences mPref;
	EditText myMemo, myPhone;
	TextView myText;
	Button smsButton, inputButton;	
	String text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.story_main);					
		myMemo = (EditText)findViewById(R.id.edittext1);
		myPhone = (EditText)findViewById(R.id.edittext2);
		myText = (TextView)findViewById(R.id.text1);
		
		smsButton = (Button)findViewById(R.id.smsbutton1);	
		inputButton = (Button)findViewById(R.id.inputbtn1);
		
		// get memo from preference
		mPref = getPreferences(MODE_PRIVATE);
		// default value is current time
		text = mPref.getString("text", "");
		// write to text view
		myText.setText(text);
		
		inputButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				saveMsg();
			}
		});
		
		smsButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callIntent();				
			}
		});	
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// save memo to text view
	public void saveMsg() {
		// get memo and append to text view
		String memo = myMemo.getText().toString();
		myText.append(memo + "\n");
	}
	
	public void callIntent() {				
		text = myText.getText().toString();
		// change new line text to tab spacing text
		// for better reading when sending SMS message 
		text = text.replaceAll("\n", "\t");
		String phone = myPhone.getText().toString();

		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.fromParts("sms", phone, null));
		intent.putExtra("sms_body", text);
		try {
			startActivity(intent);
		} catch(Exception e) {
			Log.d(TAG, "sms send fail" + e.getMessage());
		}
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onPause();
		// save memo to preference
		Editor editor = mPref.edit();
		editor.putString("text", text).commit();
	}
}