package Entities;

public abstract class Creature extends Entity {

    protected int health;
    public Creature(double x, double y) {
        super(x, y);
        health = 10;
    }

}
