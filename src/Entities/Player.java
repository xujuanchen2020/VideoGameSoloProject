package Entities;

import Gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    public Player(double x, double y) {
        super(x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int)x, (int)y, null);
    }
}
