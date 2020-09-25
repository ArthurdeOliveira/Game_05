package com.gcstudios.entities;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;




public class Player extends Entity{
	
	public int xtarget, ytarget ;
	public boolean attack = false;

	
	
	public Player(int x, int y, int width, int height,double speed,BufferedImage sprite) {
		super(x, y, width, height,speed,sprite);
	
	}
	
	public void tick(){
		Enemy enemy = null;
		for(int i = 0; i< Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if(e instanceof Enemy) {
				int xEnemy= e.getX();
				int yEnemy= e.getY();
				if(Entity.calculateDistance(this.getX(),this.getY(), xEnemy, yEnemy) <50){
					enemy = (Enemy)e;
					
				}
			}
		}
		if(enemy != null) {
			attack = true;
			enemy.vida--;
			xtarget = enemy.getX();
			ytarget = enemy.getY(); 
		}else {
			attack = false;
		}
	
	}
	
	public void render(Graphics g) {
		super.render(g);
		if(attack) {
			g.setColor(Color.RED);
			g.drawLine(this.getX() + 8, this.getY()+ 8, xtarget+8, ytarget+8);
		}
	}
}
