/* This source is provided under the Apache 2.0 License. Please see the LICENSE file for more details */
package apps101.libgdx_demo;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class MainActivity extends AndroidApplication {

	public void onCreate (android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initialize(new Game(), false);		// initialize a new instance of your Game class
	}

}