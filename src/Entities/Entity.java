package Entities;

import TileGame.Handler;

import java.awt.*;

public abstract class Entity {
    protected int health;
    protected Handler handler;
    protected double x, y;
    protected int width, height;
    protected Rectangle bounds;
    protected boolean active = true;

    public static final int DEFAULT_HEALTH = 3;

    public Entity(Handler handler, double x, double y, int width, int height) {
        health = DEFAULT_HEALTH;
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0,0,width,height);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public void hurt(int amt){
        health -= amt;
        if(health <= 0){
            active = false;
            die();
        }
    }

    protected abstract void die();

    public boolean checkEntityCollision(double xOffset, double yOffset) {
        for (Entity e: handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
                return true;
            }
        }
        return false;
    }

    public Rectangle getCollisionBounds(double xOffset, double yOffset) {
        return new Rectangle((int)(x+bounds.x+xOffset), (int)(y+bounds.y+yOffset), bounds.width, bounds.height);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public boolean isActive() {
        return active;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
