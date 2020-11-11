package TileGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.lang.Thread.State;

import Display.Display;
import Gfx.Assets;
import Gfx.ImageLoader;
import Gfx.SpriteSheet;
import States.GameState;
import States.MenuState;

public class Game implements Runnable{
	private Display display;
	public int width, height;
	public String title;
	private Thread thread;
	private Boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage testImage1, testImage2, testImage3;
	private SpriteSheet sheet;

	private States.State gameState;
	private States.State menuState;

	private KeyManager keyManager;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
	}
	
	private void init() {
		display = new Display (title, width, height);
		display.getFrame().addKeyListener(keyManager);
//		testImage1 = ImageLoader.loadImage("/textures/orange.jpg");
//		testImage2 = ImageLoader.loadImage("/textures/lotus.jpg");
//		testImage3 = ImageLoader.loadImage("/textures/zombie.jpg");
//		sheet = new SpriteSheet(testImage3);
		Assets.init();

		gameState = new GameState(this);
		menuState = new MenuState(this);
		States.State.setState(gameState);
	}
	
	public void run() {
		init();
		
		double fps = 60.0;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	private void render() {
		// draw to the screen
		bs = display.getCanvas().getBufferStrategy();
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		// call method to draw, it's a paint brush
		g = bs.getDrawGraphics();
		
		// clear the screen
		g.clearRect(0, 0, width, height);
		
//		g.setColor(Color.red);
//		g.fillRect(10, 50, 50, 80);		
//		g.setColor(Color.green);
//		g.fillRect(0, 0, 10, 10);		
//		g.drawImage(testImage1, 20, 20, null);
//		g.drawImage(testImage2, 320, 200, null);
//		g.drawImage(sheet.crop(125, 510, 44, 74), 5, 5, null);
//		g.drawImage(Assets.player, x, 10, null);
		
		if(States.State.getState() != null) {
			States.State.getState().render(g);
		}
		
		// call it to show on screen
		bs.show();
		g.dispose();
	}

	int x = 0;
	private void tick() {
//		x += 1;
		keyManager.tick();
		if(States.State.getState() != null) {
			States.State.getState().tick();
		}
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	
}
