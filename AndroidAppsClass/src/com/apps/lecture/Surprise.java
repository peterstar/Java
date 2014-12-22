package com.apps.lecture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Surprise extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Intent myIntent = new Intent();
		myIntent.setClass(this, NasaActivity.class);
		if(Math.random() > 0.5)
			myIntent.setClass(this, JavaBook.class);
		startActivity(myIntent);
		finish();
	}
}