package snake_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener, FocusListener {

	public static int viewWidth, viewHeight, gridBoxSize;
	private Snake snake;

	public enum Directions {
		LEFT, UP, RIGHT, DOWN
	}

	public Game(int viewWidth, int viewHeight) {
		this.viewHeight = viewHeight;
		this.viewWidth = viewWidth;
		this.gridBoxSize = 20;
		this.snake = new Snake(viewWidth, viewHeight, gridBoxSize);

		new Thread(new Runnable() {
			@Override
			public void run() {
				loop();
			}
		}).start();

	}

	public void loop() {
		while (true) {
			snake.move();
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void paint(Graphics g) {
		// draw grid
		g.setColor(Color.black);
		for (int i = 5; i < viewWidth - 20; i += gridBoxSize) {
			for (int j = 5; j < viewHeight - 50; j += gridBoxSize) {
				g.drawRect(i, j, gridBoxSize, gridBoxSize);
			}
		}
		// background
		g.drawImage(Main.bgImg, -10, -10, null);
		//g.fillRect(-10, -10, 900, 900);

		try {
			snake.update(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Font scoreFont = new Font("Euphemia UCAS", Font.PLAIN, 18);
		g.setFont(scoreFont);
		g.setColor(Color.white);
		g.drawString("Length: " + snake.getLength(), Game.viewWidth-130, 0+20);

	}

	@Override
	public void keyPressed(KeyEvent event) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_A:
			snake.setDirection(Directions.LEFT);
			break;
		case KeyEvent.VK_W:
			snake.setDirection(Directions.UP);
			break;
		case KeyEvent.VK_D:
			snake.setDirection(Directions.RIGHT);
			break;
		case KeyEvent.VK_S:
			snake.setDirection(Directions.DOWN);
			break;
		}

		if (event.getKeyCode() == KeyEvent.VK_Q && event.isShiftDown())
			snake.food.newLocation();

	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		//System.exit(0);

	}

}
