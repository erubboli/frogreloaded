package io.aa.games.frog;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by erubboli on 4/27/14.
 */
public class FrogSprite {
    private Batch batch;
    private Texture texture;
    public int x = 0;
    public int y = 0;
    private Camera cam;
    private int steps = 24;

    public FrogSprite(int x, int y, Camera cam, Batch batch){
      texture = new Texture("frog.png");
      this.batch = batch;
      this.x = x; this.y = y;
      this.cam = cam;
    }


    public void moveRight(){
        if( x + steps < cam.viewportWidth) {
            x += steps;
        }
    }

    public void moveLeft(){
        if( x - steps >= 0 ){
            x -= steps;
        }
    }

    public void moveDown(){
        if (y - steps >= 0) {
            y -= steps;
        }
    }
    public void moveUp() {
        if( y + steps < cam.viewportHeight){
            y += steps;
        }
    }

    public void draw(){
        batch.draw(texture, x, y);
    }

    public String toString(){
       return "Frog is at "+ Integer.toString(x) + ":" + Integer.toString(y);
    }
}
