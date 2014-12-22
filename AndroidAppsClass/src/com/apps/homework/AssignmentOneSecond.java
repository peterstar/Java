package com.apps.homework;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apps.R;

public class AssignmentOneSecond extends Activity {
	
	TextView result;
	EditText input;
	Button submit;
	private final String TAG = "HW1-2";
	private int ANSWER = 0;	
	private int count = 0;
	private final int MIN_RANGE = 1;
	private final int MAX_RANGE = 20;
	private final int ATTEMPTS = 5;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hw1_2_main);
			
		result = (TextView)findViewById(R.id.hw1_result);
		input = (EditText)findViewById(R.id.hw1_input);
		submit = (Button)findViewById(R.id.hw1_submit);
		
		generateNumber();
		
		submit.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
				
				String numInput = input.getText().toString();
				int num = Integer.parseInt(numInput);
				
				count--;
				input.setText(""); // clear number
				
				if(guessNum(num)) {
					result.setText("You got the number after " + (ATTEMPTS-count) + " attempts");
					generateNumber();
				} else {
					result.setText("You have " + count + " attempts");
				}
											
				if(count<1) {
					Toast.makeText(AssignmentOneSecond.this, "Already try 5 times. Answer is " + ANSWER + 
							"\nTry Again with new number", Toast.LENGTH_SHORT).show();
					generateNumber();
				}
										
			}				
			
		});
		
	}
	
	public boolean guessNum(int num) {
		if(num == ANSWER) {
			return true;
		} else if(num<MIN_RANGE || num>MAX_RANGE){
			Toast.makeText(this, "Out of Range input number:" + num + "\nSelect number between 1 and 20", 
					Toast.LENGTH_SHORT).show();
			return false;
		} else {
			Toast.makeText(this, "Number is not right. Try Again", Toast.LENGTH_SHORT);
			return false;			
		}
	}
	
	public void generateNumber() {
		// reset the count
		count = 5;
		Random random = new Random();
		ANSWER = random.nextInt(20) + 1;
		Log.v(TAG, String.valueOf(ANSWER));		
	}
}