/* This file is provided under the Apache 2.0 License. Please see the LICENSE file for more details */
/**
 *  Creative Commons License Attribution for the image:
 * 
 *  File:	"Yellow Happy.jpg"
 *  Author:	Jgsho (Own work)
 *  Source:	http://commons.wikimedia.org/wiki/File%3AYellow_Happy.jpg
 *  License: [CC-BY-SA-3.0 (http://creativecommons.org/licenses/by-sa/3.0)], via Wikimedia Commons
 */

package apps101.libgdx_demo;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Game implements ApplicationListener {
	
	private static final int CAMERA_WIDTH = 480;
	private static final int CAMERA_HEIGHT = 800;

	Texture smileyface;
	Rectangle rect_smiley;
	Texture helloworld;
	Rectangle rect_hello;
	OrthographicCamera camera;
	SpriteBatch batch;
	
	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT); // the camera is like a window into our game world
		batch = new SpriteBatch();
		
		/** Instantiate smiley face image **/
		smileyface = new Texture(Gdx.files.internal("128px-Yellow_Happy.jpg"));
		rect_smiley = new Rectangle();
		rect_smiley.width = 128;										// "Yellow_Happy.jpg" is 128x128 pixels
		rect_smiley.height = 128;
		rect_smiley.x = (CAMERA_WIDTH / 2) - (rect_smiley.width / 2);	// center the image horizontally
		rect_smiley.y = (CAMERA_HEIGHT / 2) - (rect_smiley.height / 2);	// center the image vertically
		
		/** Instantiate hello world image **/
		helloworld = new Texture(Gdx.files.internal("helloworld.png"));
		rect_hello = new Rectangle();
		rect_hello.width = 256;											// "helloworld.png" is 256x64 pixels
		rect_hello.height = 64;
		rect_hello.x = (CAMERA_WIDTH / 2) - (rect_hello.width / 2);		// center the image horizontally
		rect_hello.y = rect_smiley.y + 200;								// place helloworld just above the smiley face
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
	    Gdx.gl.glClearColor(0.199f, 0.398f, 0.598f, 0.4f);	// OpenGL code to make the screen blue
	    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);			// OpenGL code to clear the screen
	    camera.update();
	    
	    /** Render the smileyface image and helloworld image **/
	    batch.setProjectionMatrix(camera.combined);
	    batch.begin();
	    batch.draw(smileyface, rect_smiley.x, rect_smiley.y);
	    batch.draw(helloworld, rect_hello.x, rect_hello.y);
	    batch.end();
	    
	    
	    /** Simple technique to detect user input on the touch screen **/
	    if(Gdx.input.isTouched()) {
	        Vector3 touchPos = new Vector3();
	        touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
	        camera.unproject(touchPos);
	        
	        /** center the smiley face on the touch (x,y) coordinates **/
	        rect_smiley.x = touchPos.x - 128 / 2;
	        rect_smiley.y = touchPos.y - 128 / 2;
	    }
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}