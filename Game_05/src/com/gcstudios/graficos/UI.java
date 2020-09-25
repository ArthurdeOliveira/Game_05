package com.gcstudios.graficos;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class UI {

	public static BufferedImage HEART = Game.spritesheet.getSprite(0, 16, 16, 16);
	public static BufferedImage HALF_HEART = Game.spritesheet.getSprite(16, 16, 16, 16);
	public static BufferedImage EMPTY_HEART = Game.spritesheet.getSprite(48, 16, 16, 16);
	
	public void render(Graphics g) {
		for(int i = 0;i <(int)Game.vida ;i++) {
			g.drawImage(HEART,10+i*38,10,40,40,null);	
			}
		if(Game.vida < 3.5) {
			g.drawImage(HALF_HEART,10+2*38,10,40,40,null);
		}
		if(Game.vida < 2.5) {
			g.drawImage(HALF_HEART,10+1*38,10,40,40,null);
		}
		if(Game.vida < 1.5) {
			g.drawImage(HALF_HEART,10,10,40,40,null);
		}
		if(Game.vida < 3) {
			g.drawImage(EMPTY_HEART,10+2*38,10,40,40,null);
		}
		if(Game.vida < 2) {
			g.drawImage(EMPTY_HEART,10+1*38,10,40,40,null);
		}
		if(Game.vida <= 0) {
			g.drawImage(EMPTY_HEART,10,10,40,40,null);
		}
		
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.setColor(Color.WHITE);
		g.drawString("$: "+Game.dinheiro,Game.WIDTH*Game.SCALE - 100,20);
	}
	
}
