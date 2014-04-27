package io.aa.games.frog;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class FrogReloadedGame extends ApplicationAdapter {
    FrogSprite frog;
    SpriteBatch batch;
    OrthographicCamera camera;
    BitmapFont font;

    private static int SCREEN_WIDTH=800;
    private static int SCREEN_HEIGHT=480;

    @Override
    public void create () {
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        frog = new FrogSprite(10,240, camera, batch);
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        font = new BitmapFont();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        detectInput();
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        frog.draw();
        font.draw(batch, frog.toString(), 20, 20);
        batch.end();

    }

    public void detectInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.UP))    frog.moveUp();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))  frog.moveDown();
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))  frog.moveLeft();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) frog.moveRight();


        if(Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if(touchPos.x > frog.x){ frog.moveRight(); }
            if(touchPos.x < frog.x){ frog.moveLeft(); }
            if(touchPos.y > frog.y){ frog.moveUp(); }
            if(touchPos.y < frog.y){ frog.moveDown(); }

        }
    }

}
