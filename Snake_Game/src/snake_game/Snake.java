package snake_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Snake {
	//private ArrayList<SnakePart> snakeBody;
	private SnakePart snakeHead;
	private ArrayList<SnakePart> pastMoves;
	public Food food;
	public final int viewWidth, viewHeight, snakeWidth, speed;
	private int length;
	private Image snakeHeadImg;

	private Game.Directions direction;

	public Snake(int viewWidth, int viewHeight, int gridBoxSize) {
		this.viewHeight = viewHeight;
		this.viewWidth = viewWidth;
		this.snakeWidth = gridBoxSize;
		this.direction = Game.Directions.RIGHT;
		this.speed = 20;
		this.length = 2;
		this.snakeHeadImg = Main.snakeHeadImages[2];

		// create the head of the snake
		snakeHead = new SnakePart(5,5);
		pastMoves = new ArrayList<SnakePart>();
		food = new Food();
		pastMoves.add(snakeHead);
		// System.out.println("first construct");

	}

	public void move() {

		switch (direction) {
		case UP:
			
				snakeHead.vertMove(-1 * speed);
			
			snakeHeadImg = Main.snakeHeadImages[1];
			break;
		case RIGHT:
			snakeHead.horizMove(speed);
			snakeHeadImg = Main.snakeHeadImages[2];
			break;
		case DOWN:
			snakeHead.vertMove(speed);
			snakeHeadImg = Main.snakeHeadImages[3];
			break;
		case LEFT:
			snakeHead.horizMove(-1 * speed);
			snakeHeadImg = Main.snakeHeadImages[0];
			break;

		}
		checkForCollision();

	}

	public void checkForCollision() {
		SnakePart head = snakeHead;
		int headX = head.getX();
		int headY = head.getY();
		int partX, partY;
		for (int i = pastMoves.size() - 1; i > pastMoves.size() - length; i--) {
			// if head's x or y is equal to any of the past moves, set length to 0
			partX = pastMoves.get(i).getX();
			partY = pastMoves.get(i).getY();

			if (headX == partX && headY == partY) {
				length = 1;
				head.setX(viewWidth / 2 - 5);
				head.setY(viewHeight / 2 - 5);
			}

		}
		// food collision
		if (headX == food.getX() && headY == food.getY()) {
			length += 1;
			food.newLocation();

		}

		// wall collision
		if (headX > viewWidth - snakeWidth || headX < 0 || headY > viewHeight - snakeWidth - 15 || headY <= 0) {

			snakeHead.setX(viewWidth / 2 - 5);
			snakeHead.setY(viewHeight / 2 - 5);
			length = 0;
			pastMoves.clear();

		}
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setDirection(Game.Directions direction) {
		this.direction = direction;
	}

	public void update(Graphics g) throws IOException {
		SnakePart pastMove = snakeHead;
		pastMoves.add(new SnakePart(pastMove.getX(), pastMove.getY()));
		//System.out.println(pastMoves.size());
		if (pastMoves.size() > 100) {
			for (int j = 0; j < pastMoves.size() - 1 - length; j++) {
				pastMoves.remove(pastMoves.get(j));
			}
		}

		g.setColor(Color.cyan);

		// display past moves
		for (int i = pastMoves.size() - 1; i > pastMoves.size() - 1 - length; i--) {
			g.drawImage(Main.snakeSkinImg, pastMoves.get(i).getX(), pastMoves.get(i).getY(), null);
//			g.drawImage(Main.appleImg, x, y, null);
		}

		// System.out.println("\n\n");

			g.drawImage(snakeHeadImg, snakeHead.getX(), snakeHead.getY(), null);
		

		food.draw(g);

	}

}
