package com.example.sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SimpleSpinnerMain extends Activity {
		
	Spinner mySpinner;
	String[] myArray = new String[5];
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mySpinner = (Spinner)findViewById(R.id.spinner1);
		
		for (int i=0; i<myArray.length; i++){
			myArray[i] = Integer.toString(i+1);
		}
		
		ArrayAdapter<String> aa = new ArrayAdapter<String>(SimpleSpinnerMain.this, 
				android.R.layout.simple_spinner_item, android.R.id.text1, myArray);
		
		mySpinner.setAdapter(aa);
		
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		mySpinner.setSelection(2);
		
		
	}
}