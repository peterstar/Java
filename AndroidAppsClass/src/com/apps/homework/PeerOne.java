package com.apps.homework;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.apps.R;

public class PeerOne extends Activity {
    Button next1;
    Button previous1;
    ImageView display1;
    int counter = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.peer_one_main);
		
        next1 = (Button) findViewById(R.id.btn1);
        previous1 = (Button) findViewById(R.id.btn2);
        display1 = (ImageView) findViewById(R.id.imageView1);
         
       
        next1.setOnClickListener(new View.OnClickListener() {
           
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                counter++;
               
                if(counter == 4)
                    counter = 0;
           
                if(counter == 0)
                    display1.setImageResource(R.drawable.ee1);
                   
                if(counter == 1)
                    display1.setImageResource(R.drawable.ee2);
                   
                if(counter == 2)
                    display1.setImageResource(R.drawable.ee311);
                   
                if(counter == 3)
                    display1.setImageResource(R.drawable.ee312);               
               
            }
        });
       
        previous1.setOnClickListener(new View.OnClickListener() {
           
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
               
                counter--;
               
                if(counter == -1)
                    counter = 3;
               
                if(counter == 0)
                    display1.setImageResource(R.drawable.ee1);                   
               
                if(counter == 1)
                    display1.setImageResource(R.drawable.ee2);
                   
                if(counter == 2)
                    display1.setImageResource(R.drawable.ee311);
                   
                if(counter == 3)
                    display1.setImageResource(R.drawable.ee312);       
                   
            }
        });
		
	}
}