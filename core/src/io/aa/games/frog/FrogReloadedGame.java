package io.aa.games.frog;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class FrogReloadedGame extends ApplicationAdapter {
    OrthographicCamera camera;
    FrogSprite frog;
    Screen screen;
	private static int SCREEN_WIDTH=800;
    private static int SCREEN_HEIGHT=480;
	@Override
	public void create () {
        camera = new OrthographicCamera();
        screen = new Screen(SCREEN_WIDTH, SCREEN_HEIGHT);
        frog = new FrogSprite(10,240, screen);
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	@Override
	public void render () {
        detectInput();
        screen.draw();
        frog.draw();
    }

    public void detectInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) frog.moveUp();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) frog.moveDown();
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) frog.moveLeft();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) frog.moveRight();


        if(Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if(touchPos.x > frog.x){ frog.moveLeft(); }
            if(touchPos.x < frog.x){ frog.moveRight(); }
            if(touchPos.y < frog.y){ frog.moveDown(); }
            if(touchPos.y > frog.y){ frog.moveUp(); }

        }
    }

}
