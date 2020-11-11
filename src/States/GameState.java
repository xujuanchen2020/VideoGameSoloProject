package States;

import java.awt.Graphics;

import Gfx.Assets;

public class GameState extends State {
	
	public GameState() {
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.dirt, 0, 0, null);
		
	}
}
