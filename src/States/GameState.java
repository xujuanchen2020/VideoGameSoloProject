package States;

import java.awt.Graphics;

import Entities.Player;
import Gfx.Assets;
import Tile.Tile;
import TileGame.Game;


public class GameState extends State {

	private Player player;

	public GameState(Game game) {
		super(game);
		player = new Player(game,100,100);
	}

	@Override
	public void tick() {
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
//		g.drawImage(Assets.dirt, 0, 0, null);
		player.render(g);
		Tile.tiles[0].render(g,0,0);
		Tile.tiles[1].render(g,64,0);
		Tile.tiles[2].render(g,128,0);
	}
}
