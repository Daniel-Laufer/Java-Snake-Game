package snake_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Food {
	int x, y;
	
	
	public Food(){
		this.x = 5 + Game.gridBoxSize;
		this.y = 5 + Game.gridBoxSize;
			
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void loadImage() throws IOException {
		
	}

	public void draw(Graphics g) throws IOException {
		
		g.drawImage(Main.appleImg, x, y, null);
		
		
		//g.setColor(Color.GREEN);
		//g.fillRect(x, y, Game.gridBoxSize, Game.gridBoxSize);
	}
	
	public void newLocation() {
		this.x = 5 + Game.gridBoxSize + Math.abs((Game.gridBoxSize*((int) (Math.random()*(Game.viewWidth/Game.gridBoxSize-40)))));
		this.y = 5 + Game.gridBoxSize + Math.abs((Game.gridBoxSize*((int) (Math.random()*(Game.viewHeight/Game.gridBoxSize-40)))));
		//System.out.println("New location X:" + x + " y: " + y);
//		this.x = (int) (Math.random()*(Game.viewWidth)) + 20;
//		this.y = (int) (Math.random()*(Game.viewWidth)) + 20;
	}
	
}
