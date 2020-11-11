package States;

import java.awt.Graphics;

import Entities.Player;
import Gfx.Assets;

public class GameState extends State {

	private Player player;

	public GameState() {
		player = new Player(100,100);
	}

	@Override
	public void tick() {
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
//		g.drawImage(Assets.dirt, 0, 0, null);
		player.render(g);
	}
}
