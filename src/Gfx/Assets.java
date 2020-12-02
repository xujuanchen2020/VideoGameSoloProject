package Gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

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
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/grassMap.png"));
		grass = sheet.crop(width*4,height*9,width,height);

		dirt = ImageLoader.loadImage("/textures/stoneBlock.png");
		rock = ImageLoader.loadImage("/textures/Crate.png");
		tree = ImageLoader.loadImage("/textures/Tree.png");
		wood = ImageLoader.loadImage("/textures/stoneBlock.png");

		inventoryScreen = ImageLoader.loadImage("/textures/board.png");

		player_down = new BufferedImage[5];
		player_up = new BufferedImage[5];
		player_left = new BufferedImage[5];
		player_right = new BufferedImage[5];

		player_down[0] = ImageLoader.loadImage("/textures/bl_dn_0.gif");
		player_down[1] = ImageLoader.loadImage("/textures/bl_dn_1.gif");
		player_down[2] = ImageLoader.loadImage("/textures/bl_dn_2.gif");
		player_down[3] = ImageLoader.loadImage("/textures/bl_dn_3.gif");
		player_down[4] = ImageLoader.loadImage("/textures/bl_dn_4.gif");

		player_up[0] = ImageLoader.loadImage("/textures/bl_up_0.gif");
		player_up[1] = ImageLoader.loadImage("/textures/bl_up_1.gif");
		player_up[2] = ImageLoader.loadImage("/textures/bl_up_2.gif");
		player_up[3] = ImageLoader.loadImage("/textures/bl_up_3.gif");
		player_up[4] = ImageLoader.loadImage("/textures/bl_up_4.gif");

		player_left[0] = ImageLoader.loadImage("/textures/bl_lt_0.gif");
		player_left[1] = ImageLoader.loadImage("/textures/bl_lt_1.gif");
		player_left[2] = ImageLoader.loadImage("/textures/bl_lt_2.gif");
		player_left[3] = ImageLoader.loadImage("/textures/bl_lt_3.gif");
		player_left[4] = ImageLoader.loadImage("/textures/bl_lt_4.gif");

		player_right[0] = ImageLoader.loadImage("/textures/bl_rt_0.gif");
		player_right[1] = ImageLoader.loadImage("/textures/bl_rt_1.gif");
		player_right[2] = ImageLoader.loadImage("/textures/bl_rt_2.gif");
		player_right[3] = ImageLoader.loadImage("/textures/bl_rt_3.gif");
		player_right[4] = ImageLoader.loadImage("/textures/bl_rt_4.gif");

		btn_start = new BufferedImage[2];
		btn_start[0] = ImageLoader.loadImage("/textures/startButton.gif");
		btn_start[1] = ImageLoader.loadImage("/textures/yes.png");
	}

}
