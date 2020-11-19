package TileGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    public boolean[] keys, justPressed, cantPressed;
    public boolean up, down, left, right, up_W, down_S, left_A, right_D;

    public KeyManager() {
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPressed = new boolean[keys.length];
    }

    public void tick() {
        for(int i = 0; i < keys.length; i++){
            if(cantPressed[i] && !keys[i]){
                cantPressed[i] = false;
            }else if (justPressed[i]){
                cantPressed[i] = true;
                justPressed[i] = false;
            }
            if(!cantPressed[i] && keys[i]){
                justPressed[i] = true;
            }
        }
        if(keyJustPressed(KeyEvent.VK_E)){
            System.out.println("E JUST PRESSED");
        }

        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];

        up_W = keys[KeyEvent.VK_W];
        down_S = keys[KeyEvent.VK_S];
        left_A = keys[KeyEvent.VK_A];
        right_D = keys[KeyEvent.VK_D];
    }

    public boolean keyJustPressed(int keyCode){
        if(keyCode < 0 || keyCode >= keys.length)
            return false;
        return justPressed[keyCode];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length){
            return;
        }
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("key pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
