package Entities;

import Gfx.Assets;
import TileGame.Handler;
import TileGame.Item;
import Tiles.Tile;

import java.awt.*;

public class Tree extends StaticEntity {
    public Tree(Handler handler, double x, double y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT*2);

        bounds.x = 50;
        bounds.y = 158;
        bounds.width = 40;
        bounds.height = 96;
    }

    @Override
    public void tick() {

    }

    @Override
    public void die() {
        handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x,(int)y));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree,
                (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()),
                width, height, null);

        g.setColor(Color.red);
        g.drawRect(
                (int)(x+bounds.x- handler.getGameCamera().getxOffset()),
                (int)(y+bounds.y- handler.getGameCamera().getyOffset()),
                bounds.width,
                bounds.height);
    }
}
