package Entities;

import Gfx.Assets;
import TileGame.Handler;
import Tiles.Tile;

import java.awt.*;

public class Rock extends StaticEntity{
    public Rock(Handler handler, double x, double y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
        bounds.x = 3;
        bounds.y = (int)(height/2f);
        bounds.width = width - 6;
        bounds.height = (int)(height - height/2f);
    }

    @Override
    public void tick() {

    }

    @Override
    public void die() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.rock,
                (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()),
                width, height, null);
    }
}
