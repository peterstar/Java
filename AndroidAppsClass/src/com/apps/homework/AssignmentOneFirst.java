package com.apps.homework;

import com.example.apps.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class AssignmentOneFirst extends Activity {
	TextView name, description;
	ImageView image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hw1_1_main);
		Log.e("HW-1", "Famous Computer Scientist");
		name = (TextView)findViewById(R.id.cs_name);
		description = (TextView)findViewById(R.id.cs_description);
		image = (ImageView)findViewById(R.id.cs_image);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}