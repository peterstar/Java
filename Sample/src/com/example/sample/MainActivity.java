package com.example.sample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Add View
        LinearLayout myLayout = new LinearLayout(this);
        myLayout.setOrientation(LinearLayout.VERTICAL);
        myLayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
        		LayoutParams.WRAP_CONTENT));
        
        EditText edit = new EditText(this);
        edit.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
        		LayoutParams.WRAP_CONTENT));
        
        Button button = new Button(this);
        button.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
        		LayoutParams.WRAP_CONTENT));
        
        button.setText("Button");
        
        myLayout.addView(edit);
        myLayout.addView(button);
        
        //setContentView(R.layout.activity_main);
        
        // Disappear Title bar
        // set before call setContentView
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        // show progress bar
        requestWindowFeature(Window.FEATURE_PROGRESS);
        // or circle 
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        
        // add image
        requestWindowFeature(Window.FEATURE_RIGHT_ICON);
        setContentView(R.layout.activity_main);
        
        setProgress(5000);
        setProgressBarVisibility(true);
        
        setFeatureDrawableResource(Window.FEATURE_RIGHT_ICON, R.drawable.ic_launcher);
        
        
    }

    
    
}
