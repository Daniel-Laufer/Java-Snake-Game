package snake_game;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

	private static final int viewWidth = 500;
	private static final int viewHeight = 500;
	public static Image appleImg, bgImg, snakeSkinImg;
	public static Image[] snakeHeadImages;
	public static void main(String[] args) throws IOException {
		
		appleImg = ImageIO.read(Main.class.getClassLoader().getResource("res/apple.png"));
	
		
		bgImg = ImageIO.read(Main.class.getClassLoader().getResource("res/dark.jpg"));
		snakeSkinImg = ImageIO.read(Main.class.getClassLoader().getResource("res/snakeSkin.png"));
		snakeHeadImages = new Image[4];
		snakeHeadImages[0] = ImageIO.read(Main.class.getClassLoader().getResource("res/snakeHeadLeft.png"));
		snakeHeadImages[1] = ImageIO.read(Main.class.getClassLoader().getResource("res/snakeHeadUp.png"));
		snakeHeadImages[2] = ImageIO.read(Main.class.getClassLoader().getResource("res/snakeHeadRight.png"));
		snakeHeadImages[3] = ImageIO.read(Main.class.getClassLoader().getResource("res/snakeHeadDown.png"));
		
		

		// create JFrame
		JFrame frame = new JFrame("Snake Game");
		frame.setIconImage(new ImageIcon(Main.class.getClassLoader().getResource("res/apple.png")).getImage());
		frame.setBounds((1920 - viewWidth), 0, viewWidth, viewHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
		
		

		// start the game
		Game game = new Game(viewWidth, viewHeight);
		
		
		
		
		
		
		frame.requestFocus();
		// add the canvas to the JFrame
		frame.add(game);
		// add the key listeners to the JFrame
		frame.addKeyListener(game);
		frame.addFocusListener(game);

	}

}
