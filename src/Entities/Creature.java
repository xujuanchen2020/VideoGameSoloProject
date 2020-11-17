package Entities;

import TileGame.Handler;
import Tiles.Tile;

public abstract class Creature extends Entity {

    protected int health;
    protected double speed;
    protected double xMove, yMove;

    public static final int DEFAULT_HEALTH = 10;
    public static final double DEFAULT_SPEED = 3.0;
    public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;

    public Creature(Handler handler, double x, double y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        if(!checkEntityCollision(xMove, 0f))
            moveX();
        if(!checkEntityCollision(0f,yMove))
            moveY();
    }

    public void moveX() {// move right
        if(xMove > 0){//Moving right
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;

            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
                x += xMove;
            }else{
                x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
            }

        }else if(xMove < 0){//Moving left
            int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;

            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
                x += xMove;
            }else{
                x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
            }

        }
    }

    public void moveY() {
        if(yMove < 0){//Up
            int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;

            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)){
                y += yMove;
            }else{
                y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
            }

        }else if(yMove > 0){//Down
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;

            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)){
                y += yMove;
            }else{
                y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
            }

        }
    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x,y).isSolid();
    }
    // getters and setters
    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }

    public void setxMove(double xMove) {
        this.xMove = xMove;
    }

    public void setyMove(double yMove) {
        this.yMove = yMove;
    }

    public double getxMove() {
        return xMove;
    }

    public double getyMove() {
        return yMove;
    }
}
