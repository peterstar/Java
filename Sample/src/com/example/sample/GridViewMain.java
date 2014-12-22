package com.example.sample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class GridViewMain extends Activity {
	GridView gridview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview_main);		
		gridview = (GridView)findViewById(R.id.gridview);
		
		gridview.setAdapter(new MyImageAdapter(this));
		
	} // onCreate
	
	public class MyImageAdapter extends BaseAdapter {
		Context context;
		
		Integer[] images = { R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic1,
                R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic1,
                R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6 };

		public MyImageAdapter(Context context) {
			// TODO Auto-generated constructor stub
			this.context = context;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return images.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageview;
			
			if(convertView == null){
				imageview = new ImageView(context);
				imageview.setLayoutParams(new GridView.LayoutParams(60, 60));
				imageview.setScaleType(ScaleType.FIT_CENTER);
				imageview.setPadding(10, 10, 10, 10);
								
			} else {
				imageview = (ImageView)convertView;
			}
			
			imageview.setImageResource(images[position]);
			
			// TODO Auto-generated method stub
			return imageview;
		}
		
	}
	
}
