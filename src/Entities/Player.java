package Entities;

import Gfx.Assets;
import TileGame.Game;

import java.awt.*;

public class Player extends Creature {

    public Player(Game game, double x, double y) {
        super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
    }

    @Override
    public void tick() {
//        if(game.getKeyManager().up){
//            y -= 3;
//        }
//        if(game.getKeyManager().down){
//            y += 3;
//        }
//        if(game.getKeyManager().left){
//            x -= 3;
//        }
//        if(game.getKeyManager().right){
//            x += 3;
//        }

        getInput();
        move();
        game.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (game.getKeyManager().up){
            yMove = -speed;
        }
        if (game.getKeyManager().down){
            yMove = speed;
        }
        if (game.getKeyManager().left){
            xMove = -speed;
        }
        if (game.getKeyManager().right){
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.player,
                (int)(x - game.getGameCamera().getxOffset()),
                (int)(y - game.getGameCamera().getyOffset()),
                width, height,null);
    }
}
