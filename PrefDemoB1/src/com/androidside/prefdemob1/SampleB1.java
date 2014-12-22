package com.androidside.prefdemob1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SampleB1 extends Activity {
	
    EditText wifi;
    EditText network;
    EditText bluetooth;
    EditText device;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
        wifi = (EditText) findViewById(R.id.wifi);
        network = (EditText) findViewById(R.id.network);
        bluetooth = (EditText) findViewById(R.id.bluetooth);
        device = (EditText) findViewById(R.id.device);
        
        Button button = (Button) findViewById(R.id.Edit);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent local = new Intent(SampleB1.this, PrefEdit.class);
				startActivity(local);
			}
		});
	} // onCreate
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(this);
		wifi.setText(new Boolean(p.getBoolean("wifi", false)).toString());
		network.setText(p.getString("network", ""));
		bluetooth.setText(new Boolean(p.getBoolean("bluetooth", false)).toString());
		device.setText(p.getString("device", ""));
	}
}