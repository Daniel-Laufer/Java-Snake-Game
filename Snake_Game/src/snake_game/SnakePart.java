package snake_game;

public class SnakePart{

	private int x, y;
	public SnakePart(int x, int y) {
		this.x = x;
		this.y = y;
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
	
	public void horizMove(int speed) {
		this.x+= speed;
	}
	public void vertMove(int speed) {
		this.y+= speed;
	}
	
	
	
}
