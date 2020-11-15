package Entities;

import TileGame.Game;
import TileGame.Handler;

import java.awt.*;

public abstract class Entity {
    protected Handler handler;
    protected double x, y;
    protected int width, height;
    protected Rectangle bounds;

    public Entity(Handler handler, double x, double y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0,0,width,height);
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

    public abstract void tick();
    public abstract void render(Graphics g);
}
