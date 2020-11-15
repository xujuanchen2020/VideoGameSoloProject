package Gfx;

import Entities.Entity;
import TileGame.Game;

public class GameCamera {
    private Game game;
    private double xOffset, yOffset;

    public GameCamera(Game game, double xOffset, double yOffset) {
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - game.getWidth()/2 + e.getWidth()/2;
        yOffset = e.getY() - game.getHeight()/2 + e.getHeight()/2;
    }

    public void move(double xAmt, double yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
    }

    public double getxOffset() {
        return xOffset;
    }

    public double getyOffset() {
        return yOffset;
    }

    public void setxOffset(double xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(double yOffset) {
        this.yOffset = yOffset;
    }
}
