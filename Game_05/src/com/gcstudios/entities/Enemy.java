package com.gcstudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.world.AStar;
import com.gcstudios.world.Camera;
import com.gcstudios.world.Vector2i;
import com.gcstudios.world.World;

public class Enemy extends Entity{
	
	public static boolean right = true,dead = false;
	
	public double vida = 100;
	
	public static BufferedImage[] enemyRight;

	public  BufferedImage[] enemyDead;
	

	private int frames = 0,maxFrames = 10,index = 0, maxIndex = 3;
	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		path = AStar.findPath(Game.world, new Vector2i( this.getX()/16,this.getY()/16) , new Vector2i(World.xFINAL,World.yFINAL));	
		
		enemyRight = new BufferedImage[4];
		enemyDead = new BufferedImage[4];
		
		
		for(int i = 0; i < 4; i++) {
			enemyDead[i] = Game.spritesheet.getSprite(80 + (i*16), 32, 16, 16);
			}
		
		
		for(int i = 0; i < 4; i++) {
			enemyRight[i] = Game.spritesheet.getSprite(32 + (i*20), 0, 20, 16);
			}
			
			
	}
	
	public void tick() {
	
		if(this.vida <= 0) {
			dead = true;
		}
	
		followPath(path);
		if(x >= Game.WIDTH) {
			Game.vida-=0.5;
			Game.entities.remove(this);
			
			return;
		}
	
		
	frames++;
	if (frames == maxFrames) {
		frames = 0;
		index++;
		if (index > maxIndex) {
			index =0;
		}
	}
	if(vida <= 0) {
		Game.entities.remove(this);
		Game.dinheiro++;
		return;
	}
	}
	
	public void render(Graphics g) {
		if (right) {
			g.drawImage(enemyRight[index], this.getX() - Camera.x, this.getY()- Camera.y , null);
			g.setColor(Color.RED);
			g.fillRect((int)x,(int)y-5, (int)(100*0.18), 2);
			g.setColor(Color.GREEN);
			g.fillRect((int)x,(int)y-5, (int)(vida*0.18), 2);
		}else {
			g.drawImage(enemyDead[index], this.getX(), this.getY(), null);
		}
		
		
		
	}
}
