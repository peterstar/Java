package com.example.sample;

import android.app.TabActivity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabHostMain extends TabActivity {
	TabHost tabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabhost_main2);

		// for Activity
		// tabHost = (TabHost)findViewById(R.id.tabhost);
		// tabHost.setup();

		TabHost tabhost1 = getTabHost();

		TabSpec tabspec1 = tabhost1.newTabSpec("tab1").setIndicator("TAB 1");
		tabspec1.setContent(R.id.tab1);
		tabhost1.addTab(tabspec1);

		TabSpec tabspec2 = tabhost1.newTabSpec("tab2").setIndicator("TAB 2");
		tabspec2.setContent(R.id.tab2);
		tabhost1.addTab(tabspec2);

		Drawable img = getResources().getDrawable(R.drawable.star);
		TabSpec tabspec3 = tabhost1.newTabSpec("tab3").setIndicator("TAB 3",
				img);
		tabspec3.setContent(R.id.tab3);

		tabhost1.addTab(tabspec3);

		tabhost1.setCurrentTab(0);

	}
}