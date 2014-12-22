package com.androidside.prefdemoc1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SampleC1 extends DialogPreference {

	SharedPreferences pref;
	
    EditText idEdit;
    EditText pwEdit;
    
	public SampleC1(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		pref = getContext().getSharedPreferences(getKey(), Context.MODE_PRIVATE);
	}
	
	@Override
	protected View onCreateDialogView() {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.logindialog, null);
		
		idEdit = (EditText) layout.findViewById(R.id.id);
		pwEdit = (EditText) layout.findViewById(R.id.pw);
		
		idEdit.setText(pref.getString("id", ""));
		pwEdit.setText(pref.getString("pw", ""));
						
		return layout;
	}
	
	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		//super.onClick(dialog, which);
		
		if(which == DialogInterface.BUTTON1){
			pref = getContext().getSharedPreferences(getKey(), Context.MODE_PRIVATE);
			Editor editor = pref.edit();
			
			editor.putString("id", idEdit.getText().toString());
			editor.putString("pw", pwEdit.getText().toString());
			
			editor.commit();
		}
	}
	
}