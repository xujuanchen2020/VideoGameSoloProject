package Entities;

import Gfx.Animation;
import Gfx.Assets;
import Inventory.Inventory;
import TileGame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {
    private Animation animationDown, animationUp, animationLeft, animationRight;
    private long lastAttackTimer, attackCooldown = 500, attackTimer = attackCooldown;
    private Inventory inventory;

    public Player(Handler handler, double x, double y) {
        super(handler, x, y, 80, 96);
        bounds.x = 22;
        bounds.y = 44;
        bounds.width = 19;
        bounds.height =19;

        //animation
        animationDown = new Animation(500,Assets.player_down);
        animationUp = new Animation(500,Assets.player_up);
        animationLeft = new Animation(500,Assets.player_left);
        animationRight = new Animation(500,Assets.player_right);

        inventory = new Inventory(handler);
    }

    @Override
    public void tick() {
        animationDown.tick();
        animationUp.tick();;
        animationLeft.tick();
        animationRight.tick();

        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

        checkAttack();

        inventory.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(),
                (int)(x - handler.getGameCamera().getxOffset()),
                (int)(y - handler.getGameCamera().getyOffset()),
                width, height,null);
        inventory.render(g);
    }

    public void postRender(Graphics g){
        inventory.render(g);
    }

    private void checkAttack() {
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        ;lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown){
            return;
        }

        if(inventory.isActive())
            return;
        Rectangle cb = getCollisionBounds(0,0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if (handler.getKeyManager().up) {
            ar.x = cb.x + cb.width/2 - arSize/2;
            ar.y = cb.y - arSize;
        }else if (handler.getKeyManager().down) {
            ar.x = cb.x + cb.width/2 - arSize/2;
            ar.y = cb.y + cb.height;
        }else if (handler.getKeyManager().left) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height/2 - arSize/2;
        }else if (handler.getKeyManager().right) {
            ar.x = cb.x + arSize;
            ar.y = cb.y + cb.height/2 - arSize/2;
        }else{
            return;
        }

        attackTimer = 0;

        for(Entity e: handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }
            if(e.getCollisionBounds(0,0).intersects(ar)){
                e.hurt(1);
                return;
            }
        }
    }

    public void die(){
        System.out.println("You Lose");
    }

    private void getInput() {
        if(inventory.isActive())
            return;
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up){
            yMove = -speed;
        }
        if (handler.getKeyManager().down){
            yMove = speed;
        }
        if (handler.getKeyManager().left){
            xMove = -speed;
        }
        if (handler.getKeyManager().right){
            xMove = speed;
        }
    }

    private BufferedImage getCurrentAnimationFrame() {
        if(xMove < 0) {
            return animationLeft.getCurrentFrame();
        }else if (xMove > 0) {
            return animationRight.getCurrentFrame();
        }else if (yMove < 0) {
            return animationUp.getCurrentFrame();
        }else {
            return animationDown.getCurrentFrame();
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


}
