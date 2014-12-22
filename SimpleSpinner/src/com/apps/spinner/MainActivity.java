package com.apps.spinner;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	Spinner mySpinner;
	String[] myArray = {"Spring", "Summer", "Autumn", "Winter"};
	
	String[] myUrl = {"http://en.wikipedia.org/wiki/Spring_%28season%29",
			"http://en.wikipedia.org/wiki/Summer",
			"http://en.wikipedia.org/wiki/Autumn",
			"http://en.wikipedia.org/wiki/Winter"
	};
	ImageView myImage;
	TextView myText;
	Button myButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myText = (TextView)findViewById(R.id.textview1);
		mySpinner = (Spinner)findViewById(R.id.spinner1);
		myImage = (ImageView)findViewById(R.id.imageview1);		
		myButton = (Button)findViewById(R.id.button1);		
		
        final Integer[] myImageArray  = {
        		R.drawable.spring,
        		R.drawable.summer,
        		R.drawable.autumn,
        		R.drawable.winter
        }; 

        myImage.setImageResource(myImageArray[0]);
        
		ArrayAdapter<String> aa = new ArrayAdapter<String>(MainActivity.this, 
				android.R.layout.simple_spinner_item, android.R.id.text1, myArray);
		
		mySpinner.setAdapter(aa);
		
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		mySpinner.setSelection(0);
		
		mySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				myImage.setImageResource(myImageArray[position]);				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				myImage.setImageResource(myImageArray[0]);
			}
		});

		myButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callIntent(mySpinner.getSelectedItemPosition());
			}
		});
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void callIntent(int num) {
		Intent i = new Intent(Intent.ACTION_VIEW);		
		i.setData(Uri.parse(myUrl[num]));
		startActivity(i);
	}

}
