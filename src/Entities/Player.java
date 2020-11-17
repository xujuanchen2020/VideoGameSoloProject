package Entities;

import Gfx.Animation;
import Gfx.Assets;
import TileGame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {
    private Animation animationDown, animationUp, animationLeft, animationRight;
    public Player(Handler handler, double x, double y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 22;
        bounds.y = 44;
        bounds.width = 19;
        bounds.height =19;

        //animation
        animationDown = new Animation(500,Assets.player_down);
        animationUp = new Animation(500,Assets.player_up);
        animationLeft = new Animation(500,Assets.player_left);
        animationRight = new Animation(500,Assets.player_right);
    }

    @Override
    public void tick() {
        animationDown.tick();
        animationUp.tick();;
        animationLeft.tick();
        animationRight.tick();

        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up){
            yMove = -speed;
        }
        if (handler.getKeyManager().down){
            yMove = speed;
        }
        if (handler.getKeyManager().left){
            xMove = -speed;
        }
        if (handler.getKeyManager().right){
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(),
                (int)(x - handler.getGameCamera().getxOffset()),
                (int)(y - handler.getGameCamera().getyOffset()),
                width, height,null);

//        g.setColor(Color.RED);
//        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
//                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
//                bounds.width,
//                bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if(xMove < 0) {
            return animationLeft.getCurrentFrame();
        }else if (xMove > 0) {
            return animationRight.getCurrentFrame();
        }else if (yMove < 0) {
            return animationUp.getCurrentFrame();
        }else {
            return animationDown.getCurrentFrame();
        }
    }
}
