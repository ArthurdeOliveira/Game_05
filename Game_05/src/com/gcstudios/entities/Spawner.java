	package com.gcstudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Spawner extends Entity {
	
	private int timer = 60;
	private int CurTimer = 0;

	public Spawner(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	
	}
	
	public void tick() {
		CurTimer ++;
		if(CurTimer == timer) {
			CurTimer = 0;
			timer = Entity.rand.nextInt(60-30)+30;
			Enemy enemy = new Enemy(this.getX(),this.getY(),16,16,1,Entity.ENEMY1_RIGHT);
			Game.entities.add(enemy);
		}
	}
	
	public void render(Graphics g) {
	//	g.setColor(Color.red);
		//g.fillRect(this.getX(), this.getY(), 16,16);
	}

}
