package alp5.u12.pong;

import org.lwjgl.input.Keyboard;

public class Player extends Entity {

	protected int up = 0;
	protected int low = 480;
	protected int left = 0;
	protected int right = 640;
	private float speed = 3.0f;
	
	public Player(Game game, String ref, float x, float y) {
		super(game, game.getSprite(ref), x, y, true);
		dx = 0;
		dy = 0;
	}

	// collisions:	none = 0	upper = lower = 1	left = right = 2
	public void handleCollision(int val) {
	}
	
	public void move() {
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) 
			y = (y-speed > 0) ? y-speed : 0;
		if (Keyboard.isKeyDown(Keyboard.KEY_UP))
			y = (y+speed < height-sprite.getHeight()) ? y+speed : height-sprite.getHeight();
	}
	
	// collisions:	none = 0	upper = lower = 1	left = right = 2
	public int collides(Ball ball) {
		int val = 0;
		if (((ball.x+ball.sprite.getWidth()== x) &&
				(ball.y+ball.sprite.getHeight() >= y) && 
				(ball.y <= y+sprite.getHeight())) || 
				((ball.x == x+sprite.getWidth()) && 
				(ball.y+ball.sprite.getHeight() >= y) &&
				(ball.y <= y+sprite.getHeight()))) {
			val = 4;
		} else {

		}
		return val;
	}
	
	public void setSpeed(float dx, float dy) {
		this.dx = dx;
		this.dy = dy;
	}
}
