package io.aa.games.frog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by erubboli on 4/27/14.
 */
public class Screen {
    private int width;
    private int height;

    public Screen(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth(){ return width; }
    public int getHeight(){ return height; }

    public void draw(){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
