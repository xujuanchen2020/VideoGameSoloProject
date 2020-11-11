package Gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
//	private static final int width = 32, height = 32;
	
	public static BufferedImage player, dirt, grass, stone, tree;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/zombie.jpg"));
		player = sheet.crop(125, 510, 44, 74);
		dirt = sheet.crop(0, 0, 32, 32);
	}
}
