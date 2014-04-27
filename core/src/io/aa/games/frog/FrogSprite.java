package io.aa.games.frog;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by erubboli on 4/27/14.
 */
public class FrogSprite {
    private SpriteBatch batch;
    private Texture texture;
    private Screen screen;
    public int x = 0;
    public int y = 0;
    private int steps = 24;

    public FrogSprite(int x, int y, Screen screen){
      texture = new Texture("frog.png");
      batch = new SpriteBatch();
      this.x = x; this.y = y;
      this.screen = screen;
    }


    public void moveRight(){
        if( x + steps < screen.getWidth()) {
            x += steps;
        }
    }
    public void moveLeft(){
        if( x - steps >= 0 ){
            x -= steps;
        }
    }

    public void moveDown(){
        if( y + steps < screen.getHeight()){
            y += steps;
        }
    }
    public void moveUp() {
        if (y - steps >= 0) {
            y -= steps;
        }
    }

    public void draw(){
        batch.begin();
        batch.draw(texture, x,  y);
        batch.end();
    }
}
