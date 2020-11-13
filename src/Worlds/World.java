package Worlds;

import Tiles.Tile;

import java.awt.*;

public class World {

    private int width, height;
    private int[][] tiles;

    public World(String path) {
        loadWorld(path);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(g, x*Tile.TITLE_WIDTH, y*Tile.TILE_HEIGHT);
            }
        }
    }

    public Tile getTile(int x, int y) {
        Tile t = Tile.tiles[tiles[x][y]];

        if (t == null){
            return Tile.dirtTile;
        }

        return t;
    }

    private void loadWorld(String path) {
        width = 64;
        height = 64;
        tiles = new int[width][height];

        for(int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = 0;
            }
        }
    }
}
