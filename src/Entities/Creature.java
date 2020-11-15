package Entities;

import TileGame.Game;

public abstract class Creature extends Entity {

    protected int health;
    protected double speed;
    protected double xMove, yMove;

    public double getyMove() {
        return yMove;
    }

    public static final int DEFAULT_HEALTH = 10;
    public static final double DEFAULT_SPEED = 3.0;
    public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;

    public Creature(Game game, double x, double y, int width, int height) {
        super(game, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        x += xMove;
        y += yMove;
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

}
