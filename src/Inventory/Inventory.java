package Inventory;

import TileGame.Handler;
import TileGame.Item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory {
    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;

    public Inventory(Handler handler){
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();
    }

    public void tick(){
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
            active = !active;
        if(!active)
            return;
        System.out.println("INVENTORY: ");
        for(Item i: inventoryItems){
            System.out.println(i.getName()+" "+i.getCount());
        }
    }

    public void render(Graphics g){
        if(!active)
            return;
    }

    public void addItem(Item item){
        for(Item i: inventoryItems){
            if(i.getId() == item.getId()){
                i.setCount(i.getCount()+item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }

    // getters and setters
    public Handler getHandler(){
        return handler;
    }

    public void setHandler(Handler handler){
        this.handler = handler;
    }
}
