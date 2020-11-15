package States;

import java.awt.Graphics;

import Entities.Player;
import Tiles.Tile;
import TileGame.Game;
import Worlds.World;


public class GameState extends State {

	private Player player;
	private World world;

	public GameState(Game game) {
		super(game);
		player = new Player(game,100,100);
		world = new World(game,"res/worlds/world1.txt");

//		game.getGameCamera().move(0,0);
	}

	@Override
	public void tick() {
		world.tick();
		player.tick();

//		game.getGameCamera().move(1,1);
	}

	@Override
	public void render(Graphics g) {
//		g.drawImage(Assets.dirt, 0, 0, null);
		world.render(g);
		player.render(g);
//		Tile.tiles[0].render(g,0,0);
//		Tile.tiles[1].render(g,64,0);
//		Tile.tiles[2].render(g,128,0);
	}
}
