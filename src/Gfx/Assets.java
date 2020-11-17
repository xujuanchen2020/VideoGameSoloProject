package Gfx;

import java.awt.image.BufferedImage;

public class Assets {
	private  static final int width = 64, height = 64;
	public static BufferedImage player, dirt, grass, stone, tree;
	public static BufferedImage[] player_down, player_up, player_left, player_right;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/zombie.jpg"));
		SpriteSheet sheetObject = new SpriteSheet(ImageLoader.loadImage("/textures/object.jpg"));
		SpriteSheet sheetSprite2 = new SpriteSheet(ImageLoader.loadImage("/textures/sprite2.jpg"));
		dirt = sheet.crop(0, 0, 32, 32);
		grass = sheetObject.crop(200, 300, 64, 64);
		stone = sheetSprite2.crop(8,165,64,64);
		tree = sheetSprite2.crop(690,75,64,64);

		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];

		player_down[0] = sheet.crop(55, 510, 44, 74);
		player_down[1] = sheet.crop(125, 510, 44, 74);

		player_up[0] = sheet.crop(195, 510, 44, 74);
		player_up[1] = sheet.crop(265, 510, 44, 74);

		player_left[0] = sheet.crop(335, 510, 44, 74);
		player_left[1] = sheet.crop(405, 510, 44, 74);

		player_right[0] = sheet.crop(475, 510, 44, 74);
		player_right[1] = sheet.crop(545, 510, 44, 74);

	}

}
