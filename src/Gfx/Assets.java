package Gfx;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Assets {
	private  static final int width = 64, height = 64;

	public static Font font28;
	public static BufferedImage player, dirt, grass, rock, tree;
	public static BufferedImage wood;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] btn_start;
	public static BufferedImage inventoryScreen;

	public static void init() {
		font28 = FontLoader.loadFont("res/fonts/slkscr.ttf",28);
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/zombie.jpg"));
		SpriteSheet sheetObject = new SpriteSheet(ImageLoader.loadImage("/textures/object.jpg"));
		SpriteSheet sheetSprite2 = new SpriteSheet(ImageLoader.loadImage("/textures/sprite2.jpg"));
		inventoryScreen = ImageLoader.loadImage("/textures/orange.jpg");

		wood = sheet.crop(width,height,width,height);

		dirt = sheet.crop(0, 0, 32, 32);
		grass = sheetObject.crop(200, 300, 64, 64);
		rock = sheetSprite2.crop(8,165,64,64);
		tree = sheetSprite2.crop(690,75,64,64);

		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];

//		player_down[0] = sheet.crop(55, 510, 44, 74);
//		player_down[1] = sheet.crop(125, 510, 44, 74);

		player_down[0] = ImageLoader.loadImage("/textures/dead(1).png");
		player_down[1] = ImageLoader.loadImage("/textures/dead(2).png");

		player_up[0] = sheet.crop(195, 510, 44, 74);
		player_up[1] = sheet.crop(265, 510, 44, 74);

		player_left[0] = sheet.crop(335, 510, 44, 74);
		player_left[1] = sheet.crop(405, 510, 44, 74);

		player_right[0] = sheet.crop(475, 510, 44, 74);
		player_right[1] = sheet.crop(545, 510, 44, 74);

		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width*5, height*4, width*2, height);
		btn_start[1] = sheet.crop(width*6, height*5, width*2, height);

	}

}
