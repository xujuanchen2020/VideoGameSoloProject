package TileGame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import Display.Display;
import Gfx.Assets;
import Gfx.GameCamera;
import Gfx.SpriteSheet;
import States.GameState;
import States.MenuState;

public class Game implements Runnable{
	private Display display;
	private int width, height;
	public String title;
	private Thread thread;
	private Boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage testImage1, testImage2, testImage3;
	private SpriteSheet sheet;

	public States.State gameState;
	public States.State menuState;

	private KeyManager keyManager;
	private MouseManager mouseManager;

	private GameCamera gameCamera;
	private Handler handler;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init() {
		display = new Display (title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();

		handler = new Handler(this);
		gameCamera = new GameCamera(handler,0,0);

		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		States.State.setState(menuState);
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
			
//			if (timer >= 1000000000) {
//				System.out.println("Ticks and Frames: " + ticks);
//				ticks = 0;
//				timer = 0;
//			}
		}
		
		stop();
	}

	private void tick() {
		keyManager.tick();
		if(States.State.getState() != null) {
			States.State.getState().tick();
		}
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
		
		if(States.State.getState() != null) {
			States.State.getState().render(g);
		}
		
		// call it to show on screen
		bs.show();
		g.dispose();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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
